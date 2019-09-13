package _006_Zigzag_conversion;

/**
 * Created by dzj on 2019.9.13.
 */
public class Solution {

    /**
     * 要输出的是按拉链方式分行后每行字符拼接的结果(没包含空格)
     *
     * @param s
     * @param rowNums
     * @return
     */
    public String convert(String s, int rowNums) {
        //先把字符串转换为char数组
        char[] cArr = s.toCharArray();
        //字符长度
        int l = cArr.length;
        //使用一个StringBuilder数组存储每行的数据
        StringBuilder[] sbArr = new StringBuilder[rowNums];
        //需要单独去实例化StringBuilder
        for (int i = 0; i < rowNums; i++) {
            sbArr[i] = new StringBuilder();
        }

        int j = 0;
        while (j < l) {
            //先处理水平向下的操作
            for (int idx = 0; idx < rowNums && j < l; idx++) {
                sbArr[idx].append(cArr[j++]);
            }
            //假如要填上空格
            /*if(j<l){
                sbArr[rowNums-1].append(" ");
            }*/

            // 倾斜向上,从倒数第二行开始,到第二行结束
            for (int idx = rowNums - 2; idx > 0 && j < l; idx--) {
                sbArr[idx].append(cArr[j++]);
            }
            //假如要填上空格
            /*if(j<l){
                sbArr[0].append(" ");
            }*/

        }
        //把三个字符串拼接在一起
        for (int idx = 1; idx < sbArr.length; idx++) {
            sbArr[0].append(sbArr[idx]);
        }

        return sbArr[0].toString();

    }


    public static void main(String[] args) {
        String oriStr = "PAYPALISHIRING";
        // 行数
        int row = 3;
        /*  row=3时预期结果：PAYPALIHIRING
            P A H N
            APLSIIG
            Y I R
         */
        System.out.println(new Solution().convert(oriStr, row));
    }
}
