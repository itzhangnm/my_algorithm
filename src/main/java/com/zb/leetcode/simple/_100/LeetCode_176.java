package com.zb.leetcode.simple._100;

/**
 * 176. 第二高的薪水
 * @author Zhang Bo
 * @date 2020/9/29 14:51
 */
public class LeetCode_176 {
    /**
     * 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
     * <p>
     * +----+--------+
     * | Id | Salary |
     * +----+--------+
     * | 1  | 100    |
     * | 2  | 200    |
     * | 3  | 300    |
     * +----+--------+
     * 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
     * <p>
     * +---------------------+
     * | SecondHighestSalary |
     * +---------------------+
     * | 200                 |
     * +---------------------+
     * <p>
     * 来源：力扣（LeetCode_148）
     * 链接：https://leetcode-cn.com/problems/second-highest-salary
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    String sql = "select ifnull((select salary from Employee order by salary desc limit 1,1),null) as SecondHighestSalary";
}
