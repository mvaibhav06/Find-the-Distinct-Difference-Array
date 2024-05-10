class DifferenceArray {
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer,Integer> temp = new HashMap<>();
        Set<Integer> dup = new HashSet<>();
        int counter = 0;

        for(int i=0; i<nums.length; i++){
            if(!dup.contains(nums[i])){
                counter++;
                dup.add(nums[i]);
            }
            temp.put(i, counter);
        }

        HashMap<Integer,Integer> suf = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            Set<Integer> a = new HashSet<>();
            for(int j=i+1; j<nums.length; j++){
                a.add(nums[j]);
            }
            suf.put(i,a.size());
        }

        int[] out = new int[nums.length];
        for(int i=0; i<out.length; i++){
            out[i] = temp.get(i) - suf.get(i);
        }
        return out;
    }
}
