import matplotlib.pyplot as plt
import numpy as np

# File to read the output from the Java program
output_file = 'output_results.txt'

# Initialize lists to store the data
arrays = []
linear_iterative = []
linear_recursive = []
binary_iterative = []
binary_recursive = []

# Read the output file
with open(output_file, 'r') as file:
    lines = file.readlines()

# Parse the results from the output file
for line in lines:
    if line.startswith("Array:"):
        arrays.append(line.split(":")[1].strip())
    elif "Linear Search Iterative:" in line:
        comparisons = int(line.split(",")[1].split("=")[1].strip())
        linear_iterative.append(comparisons)
    elif "Linear Search Recursive:" in line:
        comparisons = int(line.split(",")[1].split("=")[1].strip())
        linear_recursive.append(comparisons)
    elif "Binary Search Iterative:" in line:
        comparisons = int(line.split(",")[1].split("=")[1].strip())
        binary_iterative.append(comparisons)
    elif "Binary Search Recursive:" in line:
        comparisons = int(line.split(",")[1].split("=")[1].strip())
        binary_recursive.append(comparisons)

# Prepare the graph
array_sizes = np.arange(1, len(arrays) + 1)

plt.figure(figsize=(12, 6))

plt.plot(array_sizes, linear_iterative, marker='o', label='Linear Search (Iterative)', color='blue')
plt.plot(array_sizes, linear_recursive, marker='s', label='Linear Search (Recursive)', color='orange')
plt.plot(array_sizes, binary_iterative, marker='^', label='Binary Search (Iterative)', color='green')
plt.plot(array_sizes, binary_recursive, marker='x', label='Binary Search (Recursive)', color='red')

# Adding titles and labels
plt.title('Search Algorithm Comparisons')
plt.xlabel('Array Number')
plt.ylabel('Number of Comparisons')
plt.xticks(array_sizes)
plt.legend()
plt.grid()

# Show the plot
plt.tight_layout()
plt.savefig('search_algorithm_comparisons.png')  # Save as an image file
plt.show()
