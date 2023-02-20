const arr = [1, 2, 3, 4, 5];
const arr2 = arr.slice(0);
arr[2] = 5;
console.log(arr);
console.log(arr2);

class Rectangle {
    constructor(height, width) {
        this.height = height;
        this.width = width;
    }
}

const rectangle1 = new Rectangle(1, 1);
const rectangle2 = new Rectangle(2, 2);
const rectangle3 = new Rectangle(3, 3);
const rectangle4 = new Rectangle(4, 4);
const rectangleArr1 = [rectangle1, rectangle2, rectangle3, rectangle4];
console.log(rectangleArr1);
const rectangleArr2 = rectangleArr1.slice(0);
const tempRectangle2 = rectangleArr2[2];
tempRectangle2.height = 2222;
console.log(rectangleArr1);
console.log(rectangleArr2);
