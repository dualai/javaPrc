package struct.recursion;

public class Recursion {

    /**
     * 模型一： 在递去的过程中解决问题
     *
     * function recursion(大规模){
     *     if (end_condition){      // 明确的递归终止条件
     *         end;   // 简单情景
     *     }else{            // 在将问题转换为子问题的每一步，解决该步中剩余部分的问题
     *         solve;                // 递去
     *         recursion(小规模);     // 递到最深处后，不断地归来
     *     }
     * }
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * 7
     * 8
     * 模型二： 在归来的过程中解决问题
     *
     * function recursion(大规模){
     *     if (end_condition){      // 明确的递归终止条件
     *         end;   // 简单情景
     *     }else{            // 先将问题全部描述展开，再由尽头“返回”依次解决每步中剩余部分的问题
     *         recursion(小规模);     // 递去
     *         solve;                // 归来
     *     }
     * }
     * ---------------------
     */


}
