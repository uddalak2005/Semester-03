import numpy as np

def generate_input_arrays(filename, num_arrays, start_length, increment):
    arrays = []
    for i in range(num_arrays):
        length = start_length + i * increment
        array = np.random.randint(0, 1000, length)
        array.sort()  # Sorting the array for binary search
        arrays.append(array)
    
    with open(filename, 'w') as f:
        for array in arrays:
            f.write(','.join(map(str, array)) + '\n')

if __name__ == "__main__":
    generate_input_arrays('input_arrays.txt', num_arrays=15, start_length=100, increment=100)
