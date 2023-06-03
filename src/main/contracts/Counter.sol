//SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.20;

contract Counter {
    uint private count = 0;

    function increment() public {
        count += 1;
    }

    function decrement() public {
        count--;
    }

    function getCount() public view returns (uint) {
        return count;
    }
}
