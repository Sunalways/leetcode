package cn.lee983.Apple;

/**
 * @Auther: 62458
 * @Date: 2020/4/27 21:46
 * @Description: Given a number N,return a string consisting of "0"s
 *      and "1"s that represents its value in base -2 (negative two).
 *
 * The returned string must have no leading zeroes, unless the string is "0".
 */
public class LC1017CovertToBaseV2 {

    /**
     * 1. 原码： 符号位加上真值的绝对值，用第一位表示符号，其余位表示值
     *  [+1] 原 = 0000 0001
     *  [-1] 原 = 1000 0001
     *  8位二进制取值范围为 [1111 1111, 0111 1111]
     *  [-127, 127]
     * 2. 反码: 正数的反码是他本身, 负数的反码是在原码基础上，符号位不变，其余位取反
     *  [+1] = [0000 0001]原 = [0000 0001]反
     *  [-1] = [1000 0001]原 = [1111 1110]反
     *  反码表示负数，通常需要将其转换成原码计算
     * 3. 补码: 正数的补码是其本身, 负数的补码是其原码的基础上，符号位不变，其余各位取反，最后+1(反码的基础上+1）
     *  [+1] = [0000 0001]原 = [0000 0001]反 = [0000 0001]补
     *  [-1] = [1000 0001]原 = [1111 1110]反 = [1111 1111]补
     * 4. 负数的按位与:
     *  按位与是按照数据的内部二进制运算，若为两个负数，则按二进制补码进行按位与。
     */
    public String base2(int N) {
        StringBuffer res = new StringBuffer();
        while (N != 0) {
            res.append(N & 1);
            N = N >> 1;
        }
        return res.length() > 0 ? res.reverse().toString() : "0";
    }

    public String baseNeg2(int N) {
        StringBuffer res = new StringBuffer();
        while (N != 0) {
            res.append(N & 1);
            N = -(N >> 1);
        }
        return res.length() > 0 ? res.reverse().toString() : "0";
    }

    public static void main(String[] args) {
        LC1017CovertToBaseV2 lc1017CovertToBaseV2 = new LC1017CovertToBaseV2();
        System.out.println(lc1017CovertToBaseV2.base2(6));
        System.out.println(lc1017CovertToBaseV2.baseNeg2(6));
    }
}
