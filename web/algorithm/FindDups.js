function findDups(nums) {
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if(nums[i] == nums[j]) {
                console.log('found dups: ' + nums[i]);
                return;
            }
        }
    }
}

findDups([2,3,4,5,2]);
findDups([2,1,3,5,6]);
findDups([1,3,4,4,2]);
findDups([6,5,4,5,2]);