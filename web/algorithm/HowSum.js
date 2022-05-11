/**
 * Write a function `howSum(targetSum, numbers)` that takes in targetSum and an array of numbers as arguments.
 * 
 * The function should return an array containing any combination of elements that add up to exactly the targetSum. If there is no combination that adds up to the targetSum, then return null.
 * If there are multiple combination possible, you may rturn any single one. 
*/

/**
 * 
 * m = target sum
 * n = numbers.length
 * Brute force
 * time: O(n^m*m)
 * space: O(m)
 * 
 * Memoized 
 * time: O(n*m^2)
 * space: O(m^2)
 */

/**
 * 
 * @param {*} targetSum 
 * @param {*} numbers 
 * @returns
 */
 function howSum(targetSum, numbers) {

    if(targetSum === 0) return [];
    if(targetSum < 0) return null;
    for (const num of numbers) {
        const reminder = targetSum - num;
        const reminderResult = howSum(reminder, numbers);
        if(reminderResult !== null) {
            return [ ...reminderResult, num]
        }
    }

    return null;
}

/**
 * 
 * @param {*} targetSum 
 * @param {*} numbers 
 * @param {*} memo 
 * @returns 
 */
 function howSumMemo(targetSum, numbers, memo={}) {
    if(targetSum in memo) return memo[targetSum];
    if(targetSum === 0) return [];
    if(targetSum < 0) return null;

    for (const num of numbers) {
        const reminder = targetSum - num;
        const reminderResult = howSumMemo(reminder, numbers, memo);
        if(reminderResult !== null) {
            memo[targetSum] = [ ...reminderResult, num];
            return memo[targetSum] ;
        }
    }

    memo[targetSum] = null;
    return null;
}

console.log('Memoized')
console.log(howSumMemo(7, [2,3])); // -> [3,2,2]
console.log(howSumMemo(7, [5,3,4,7])); // -> [7]
console.log(howSumMemo(8, [2,3,5])); // -> [3,5]
console.log(howSumMemo(7, [2,4])); // -> null
console.log(howSumMemo(0, [1,2,3])); // -> []
console.log(howSumMemo(300, [7, 14])); // -> null

console.log('Brute force')
console.log(howSum(7, [2,3])); // -> [3,2,2]
console.log(howSum(7, [5,3,4,7])); // -> [7]
console.log(howSum(8, [2,3,5])); // -> [3,5]
console.log(howSum(7, [2,4])); // -> null
console.log(howSum(0, [1,2,3])); // -> []
console.log(howSum(300, [7, 14])); // -> null


