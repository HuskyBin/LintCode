/*
Merge two given sorted integer array A and B into a new sorted integer array.

Example
A=[1,2,3,4]

B=[2,4,5,6]

return [1,2,2,3,4,4,5,6]
*/
class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < A.size() || bIndex < B.size()) {
            int aValue = (aIndex == A.size()) ? Integer.MAX_VALUE : A.get(aIndex);
            int bValue = (bIndex == B.size()) ? Integer.MAX_VALUE : B.get(bIndex);
            if (aValue <= bValue && (aIndex < A.size())) {
                resultList.add(aValue);
                aIndex++;
            }
            else {
                resultList.add(bValue);
                bIndex++;
            }
        }
        return resultList;
    }
}
