import matplotlib.pyplot as plt

# Function to read comparison data from the file
def read_comparisons(filename):
    comparisons_data = {}
    with open(filename, 'r') as file:
        lines = file.readlines()
    
    current_size = None
    for line in lines:
        if "Array size" in line:
            current_size = int(line.split(":")[1].strip())
            # Initialize dictionaries if size is encountered first time
            if current_size not in comparisons_data:
                comparisons_data[current_size] = {}
        elif "Comparisons" in line:
            algorithm = line.split(" - ")[0].strip()
            comparisons = int(line.split(":")[1].strip())
            comparisons_data[current_size][algorithm] = comparisons
    
    # Debug: Print out the data for verification
    print("Comparisons data read from file:")
    for size, algos in comparisons_data.items():
        print(f"Size {size}: {algos}")
    
    return comparisons_data

# Plotting the comparison data
def plot_comparisons(comparisons_data):
    sizes = sorted(comparisons_data.keys())
    
    bubble_iterative = [comparisons_data[size].get("Bubble Sort Iterative", 0) for size in sizes]
    selection_iterative = [comparisons_data[size].get("Selection Sort Iterative", 0) for size in sizes]
    insertion_iterative = [comparisons_data[size].get("Insertion Sort Iterative", 0) for size in sizes]
    
    bubble_recursive = [comparisons_data[size].get("Bubble Sort Recursive", 0) for size in sizes]
    selection_recursive = [comparisons_data[size].get("Selection Sort Recursive", 0) for size in sizes]
    insertion_recursive = [comparisons_data[size].get("Insertion Sort Recursive", 0) for size in sizes]
    
    heap_sort = [comparisons_data[size].get("Heap Sort", 0) for size in sizes]

    # Plotting the iterative sorts
    plt.figure(figsize=(12, 8))
    plt.plot(sizes, bubble_iterative, label='Bubble Sort Iterative', marker='o')
    plt.plot(sizes, selection_iterative, label='Selection Sort Iterative', marker='o')
    plt.plot(sizes, insertion_iterative, label='Insertion Sort Iterative', marker='o')

    # Plotting the recursive sorts
    plt.plot(sizes, bubble_recursive, label='Bubble Sort Recursive', marker='x')
    plt.plot(sizes, selection_recursive, label='Selection Sort Recursive', marker='x')
    plt.plot(sizes, insertion_recursive, label='Insertion Sort Recursive', marker='x')

    # Plotting Heap Sort
    plt.plot(sizes, heap_sort, label='Heap Sort', marker='s')

    # Adding labels and title
    plt.xlabel("Array Size (n)")
    plt.ylabel("Number of Comparisons")
    plt.title("Comparisons vs. Array Size for Sorting Algorithms")
    plt.legend()
    
    # Set logarithmic scales for better visualization of growth rates
    plt.xscale('log')
    plt.yscale('log')
    
    # Display the plot
    plt.grid(True)
    plt.show()

# Reading comparison data from the text file
comparisons_data = read_comparisons('comparisons.txt')

# Plotting the comparisons
plot_comparisons(comparisons_data)
