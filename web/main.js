let $main = (function () {

    function onPageLoad() {
        console.log('::onPageLoad::')
    }

    function findDups(nums) {
        let elms = new Set(); 
        for(let i = 0; i < nums.length; i++) {
            if(!elms.add(nums[i])) {
                console.log('found dups ' + nums[i] + ' index '+i)
                return true;
            }
        }
        console.log(elms);
    }

    return {
        init() {
            onPageLoad();
            findDups([2,3,4,5,2])
        }
    }

})();

$main.init();