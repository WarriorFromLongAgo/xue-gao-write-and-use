interface Image1 {
  keyId: string;
}

// 物料左侧数据
interface Image2 {
  name: string,
  image1: Image1
}

let tempImageV1: Image2 = {
  name: "11111",
  image1: {
    keyId: "kdjdja",
  },
};

console.log("tempImageV1 = ", JSON.stringify(tempImageV1));
console.log("tempImageV1.image1 = ", JSON.stringify(tempImageV1["image1"]));







