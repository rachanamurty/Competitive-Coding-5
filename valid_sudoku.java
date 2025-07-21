// This solution checks if the given initial sudoku board is valid or not in a single pass
// TC: O(9x9) or O(n) if the number of cols and number of rows is n
// SC: O(1) - 9 sets x 3 to store and check valid row, valid col and valid box;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, HashSet<Integer>> mapRow = new HashMap<>();
        Map<Integer, HashSet<Integer>> mapCol= new HashMap<>();
        Map<Integer, HashSet<Integer>> mapBoard = new HashMap<>();


        int i =0;
        int j = 0;
        int maxLength = 9;
       
        while(i< maxLength){
            j = 0;
            while(j<maxLength) {
            //Check if element is in row
            int value =  Character.getNumericValue(board[i][j]);
            if (value == -1) {
                j++;
                continue;
            }
            if(mapRow.containsKey(i)){
                if(mapRow.get(i).contains(value)){
                    return false;
                }
                else{
                    mapRow.get(i).add(value);
                }
            }
            else{
                HashSet<Integer> set = new HashSet<>();
                set.add(value);
                mapRow.put(i, set);
            }

            //Check if element is in coloumn
            if(mapCol.containsKey(j)){
                if(mapCol.get(j).contains(value)){
                    return false;
                }
                else{
                    mapCol.get(j).add(value);
                }
            }
            else{
                HashSet<Integer> set = new HashSet<>();
                set.add(value);
                mapCol.put(j, set);
            }

            // Check if element is in box
            int boxNumber = (i / 3) * 3 + (j / 3);
            
            if(mapBoard.containsKey(boxNumber)){
                if(mapBoard.get(boxNumber).contains(value)){
                    return false;
                }
                else{
                    mapBoard.get(boxNumber).add(value);
                }
            }
            else{
                HashSet<Integer> set = new HashSet<>();
                set.add(value);
                mapBoard.put(boxNumber, set);
            }
            j = j + 1;
            }
            i = i + 1;
        }
        return true;
    }
}
