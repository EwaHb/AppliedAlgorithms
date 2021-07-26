from __future__ import print_function
import subprocess
import statistics
import csv
from timeit import default_timer as timer


java = 'java'
javac = 'javac'


def createTable(tested, extra=""):
    return open("part1/results/runtime" + extra + ".csv", "w")


def avgRuntime(writer, producer, tested, Nlist, q, seed, k):
    method = str(tested)

    runTimes = dict()
    for N in Nlist:
        runTimes[N] = []
        for i in range(10):
            newSeed = seed + 432*i
            try:
                ps = subprocess.Popen(tuple(list(producer) + [str(N)] + [str(q)] + [
                    str(newSeed)]), stdout=subprocess.PIPE, stderr=subprocess.DEVNULL)
                print(str(producer) + " with seed=" +
                      str(newSeed) + " finished")
                start = timer()
                subprocess.run(tuple(list(tested) + [str(N)] + [str(k)]),
                               stdin=ps.stdout, stdout=subprocess.PIPE, stderr=subprocess.PIPE, check=True)
                stop = timer()
                measure = stop - start
                print(str(tested) + " finshed at: " + str(measure) +
                      " with n=" + str(N) + " and q=" + str(q))
                average = measure/q
                runTimes[N].append(average)
            except subprocess.TimeoutExpired:
                break
        time = runTimes[N]
        mean = statistics.mean(time)
        stddev = statistics.stdev(time)
        writer.writerow([method[26:-2], N, mean, stddev])


def avgRuntimeWithK(producer, tested, KList, n, q, seed):
    file = createTable(tested, "-k")
    writer = csv.writer(file, delimiter=",")
    writer.writerow(["K", "Running time"])
    for k in KList:
        try:
            ps = subprocess.Popen(tuple(list(producer) + [str(n)] + [str(q)] + [
                str(seed)]), stdout=subprocess.PIPE, stderr=subprocess.DEVNULL)
            print(str(producer) + " with seed=" +
                  str(seed) + " finished")
            start = timer()
            subprocess.run(tuple(list(tested) + [str(n)] + [str(k)]),
                           stdin=ps.stdout, stdout=subprocess.PIPE, stderr=subprocess.PIPE, check=True)
            stop = timer()
            measure = stop - start
            print(str(tested) + " finshed at: " + str(measure) +
                  " with k=" + str(k))
            average = measure/q
        except subprocess.TimeoutExpired:
            break
        writer.writerow([k, average])


# run task 2
testN = [100000, 250000, 500000, 750000,
         1000000, 2000000, 3000000, 4000000, 5000000]

# producer
subprocess.run([javac, "part1/ArrayGenerator.java"], check=True)
producer = (java, '-cp', 'part1', 'ArrayGenerator')
# sorted array
subprocess.run([javac, "part1/BinarySearch.java"], check=True)
sortedArray = (java, '-cp', 'part1', 'BinarySearch')
# sorted array with tabulation
subprocess.run([javac, "-cp", "part1", "part1/Tabulation.java"], check=True)
sortedArrayTabulation = (java, '-cp', 'part1', 'Tabulation')

tested = [sortedArray, sortedArrayTabulation]
# average runtime
file = createTable(tested)
writer = csv.writer(file, delimiter=",")
writer.writerow(["Method", "N", "Running time", "Standard deviation"])
for code in tested:
    avgRuntime(writer, producer, code, testN, 9000000, 4321, 10)

kList = [2, 3, 4, 5, 6, 8, 10, 12, 16, 20, 24]
# affect of k
avgRuntimeWithK(producer, sortedArrayTabulation, kList, 2000000, 7000000, 4321)

# run task 4 and task 5
subprocess.run([javac, "-cp", "part2", "part2/Exp.java"], check=True)
result = subprocess.run(
    [java, "-cp", "part2", "Exp"], stdout=subprocess.PIPE)
print(result.stdout.decode())
