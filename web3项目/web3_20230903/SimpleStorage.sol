pragma solidity ^0.8.7;

contract SimpleStorage {
    uint256 storedData;

    mapping(string => uint256) public nameToStoredData;

    struct People {
        uint256 storedData;
        string name;
    }

    People[] public peopleArr;

    function store(uint256 _storedData) public {
        storedData = _storedData;
    }

    function retrieve() public view returns (uint256) {
        return storedData;
    }

    function addPerson(string memory _name, uint256 _storedData) public {
        peopleArr.push(People(_storedData, _name));
        nameToStoredData[_name] = _storedData;
    }
}
