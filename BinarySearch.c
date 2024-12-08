#include <stdio.h>

// Function for performing binary search
int binarySearch(int arr[], int size, int key) {
    int left = 0, right = size - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2; // Calculate the middle index

        // Check if the key is present at mid
        if (arr[mid] == key) {
            return mid; // Return the index where the key is found
        }

        // If the key is greater, ignore the left half
        if (arr[mid] < key) {
            left = mid + 1;
        }
        // If the key is smaller, ignore the right half
        else {
            right = mid - 1;
        }
    }

    // If the key is not found in the array, return -1
    return -1;
}

int main() {
    int n, key, i;

    // Take input for the size of the array
    printf("Enter the number of elements in the array: ");
    scanf("%d", &n);

    int arr[n]; // Declare an array of size 'n'

    // Take input for the elements of the array
    printf("Enter %d sorted integers:\n", n);
    for (i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Take input for the element to search
    printf("Enter the element to search: ");
    scanf("%d", &key);

    // Perform binary search
    int result = binarySearch(arr, n, key);

    // Print the result
    if (result != -1) {
        printf("Element found at index: %d\n", result);
    } else {
        printf("Element not found in the array.\n");
    }

    return 0;
}
