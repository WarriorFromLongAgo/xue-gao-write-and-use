# 1, yarn solcjs --version
yarn solcjs --abi --bin --include-path node_modules/ --base-path . -o . .\SimpleStorage.sol


D:\fjm\peoject\my_2\xue-gao-write-and-use\web3项目\web3_20230903\node_modules\.bin\solcjs --abi --bin --include-path node_modules/ --base-path . -o . .\SimpleStorage.sol

# 2, scripts compile
{
  "name": "web3_20230903",
  "version": "1.0.0",
  "main": "index.js",
  "author": "xuegao",
  "license": "MIT",
  "dependencies": {
    "solc": "^0.8.21"
  },
  "scripts": {
    "compile": "yarn solcjs --abi --bin --include-path node_modules/ --base-path . -o . SimpleStorage.sol"
  }
}