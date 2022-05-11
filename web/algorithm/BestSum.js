/**
 * Wrute a function `bestSum(targetSum, numbers)` that takes in a targetSum and an array of numbers as arguments. 
 * 
 * The function should return an array containing the shortest combination of numbers that add up to exactly the targetSum.
 * 
 * If there is a tie for the shortest combination, you may return any one of the shortest.
 */
/***
 * m = target sum
 * n = numbers.length
 * 
 * Brute force
 * time: O(n^m*m)
 * space: O(m^2)
 */

/**
 * 
 * @param {*} targetSum 
 * @param {*} numbers 
 * @returns 
 */
 function bestSum(targetSum, numbers) {
    if(targetSum === 0) return [];
    if(targetSum < 0) return null;

    let shortestCombination = null;

    for(let num of numbers) {
        const reminder = targetSum - num;
        const reminderCombination = bestSum(reminder, numbers);
        if(reminderCombination != null) {
            const combination = [ ...reminderCombination, num];
            if(shortestCombination === null || combination.length <  shortestCombination.length) {
                shortestCombination = combination;
            }
        }
    }

    return shortestCombination;

}

function bestSumMemo(targetSum, numbers, memo = {}) {
    if(targetSum in memo) return memo[targetSum];
    if(targetSum === 0) return [];
    if(targetSum < 0) return null;

    let shortestCombination = null;

    for(let num of numbers) {
        const reminder = targetSum - num;
        const reminderCombination = bestSumMemo(reminder, numbers, memo);
        if(reminderCombination != null) {
            const combination = [ ...reminderCombination, num];
            if(shortestCombination === null || combination.length <  shortestCombination.length) {
                shortestCombination = combination;
            }
        }
    }

    memo[targetSum] = shortestCombination;

    return shortestCombination;
}

console.log('Memoized');
console.log(bestSumMemo(7, [5,3,4,7])) // -> [7]
console.log(bestSumMemo(8, [2,3,5])) // -> [3,5]
console.log(bestSumMemo(8, [1,4,5])) // -> [4,4]
console.log(bestSumMemo(100, [1,2,5,25])) // -> [25,25,25,25]

console.log('Brute force');
console.log(bestSum(7, [5,3,4,7])) // -> [7]
console.log(bestSum(8, [2,3,5])) // -> [3,5]
console.log(bestSum(8, [1,4,5])) // -> [4,4]
console.log(bestSum(100, [1,2,5,25])) // -> [25,25,25,25]
