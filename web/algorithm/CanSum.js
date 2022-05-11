function canSum(target, nums) {
    if(target === 0) return true;
    if(target < 0) return false;

    for (let i = 0; i < nums.length; i++) {
        let reminder = target - nums[i];
        if(canSum(reminder, nums) === true) {
            return true;
        }
    }
    return false;
}

function canSumMemo(target, nums, memo={}) {
    if(target === 0) return true;
    if(target < 0) return false;

    for(let num of nums) {
        let reminder = target - num;
        if(canSumMemo(reminder, nums) === true) {
            memo[target] = true;
            return true;
        }
    }
    memo[target] = false;
    return false;

}

console.log('Brute Force');
console.log(canSumMemo(8, [2,3,4,6,2]));  // true
console.log(canSumMemo(5, [3,4,6]));  // false
console.log(canSumMemo(6, [2,3,4,6,2])); // true
console.log(canSumMemo(3000, [2,3,4,6,2])); // true
console.log('Memoize');
console.log(canSum(8, [2,3,4,6,2])); // true
console.log(canSum(5, [3,4,6])); // false
console.log(canSum(6, [2,3,4,6,2])); // true
console.log(canSum(3000, [2,3,4,6,2])); // true