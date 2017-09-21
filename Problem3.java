

// Problem 3 - list separation 
    public boolean separate(List<Integer> list, int k){
        if (k <= 0 || k > list.size()) {
            // there can't be any groups of negative or 0 length
            // also there can't be more than list-size number of groups
            return false;
        }

        // when k is 1, we can have one group
        if (k == 1) {
            return true;
        }

        // sum all elements of list
        int sum = 0;
        for (int i : list) {
            sum += i;
        }

        // since all groups have same sum, total list sum has to be multiple of k
        if (sum % k != 0) {
            return false;
        }

        // sum of each group then has to be sum / k
        int sumOfEachGroup = sum / k;
        boolean[] isElementUsed = new boolean[list.size()];
        int[] groupSum = new int[k];

        groupSum[0] = list.get(list.size() - 1);
        isElementUsed[list.size() - 1] = true;

        return separateUtil(list, k, groupSum, isElementUsed, sumOfEachGroup, 0, list.size() - 1 );
    }

    private boolean separateUtil(List<Integer> list, int k, int[] groupSum,
                                 boolean[] isElementUsed, int sumOfEachGroup,
                                 int groupsFound, int nextElementIndex) {

        if (groupSum[groupsFound] == sumOfEachGroup) {
            if (groupsFound + 1 == k) {
                return true;
            }
            return separateUtil(list, k, groupSum, isElementUsed, sumOfEachGroup, groupsFound + 1, list.size() - 1);
        }


        for (int i = nextElementIndex; i >= 0; i--) {
            if (!isElementUsed[i]) {
                int newGroupSum = groupSum[groupsFound] + list.get(i);
                if (newGroupSum <= sumOfEachGroup) {
                    groupSum[groupsFound] = newGroupSum;
                    isElementUsed[i] = true;

                    boolean separationPossible = separateUtil(list, k, groupSum, isElementUsed, sumOfEachGroup, groupsFound, i - 1);

                    groupSum[groupsFound] = groupSum[groupsFound] - list.get(i);
                    isElementUsed[i] = false;

                    if (separationPossible) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
