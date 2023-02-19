const array1 = ["a", "b", "c", "d", "e", "f", "g"];

// Copy to index 0 the element at index 3
let tempArray1 = array1.copyWithin(0, 1, 3);
console.log(tempArray1);
// Expected output: Array ["d", "b", "c", "d", "e"]

console.log(" =================================== ");

// Copy to index 1 all elements from index 3 to the end
console.log(array1.copyWithin(1, 3));
// Expected output: Array ["d", "d", "e", "d", "e"]