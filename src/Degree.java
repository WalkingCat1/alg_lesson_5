/**
 * Created by Наталья on 18.09.2018.
 */
public class Degree {
    public static void main(String ... args){
        System.out.println(extent(2, 8));

        int[] costs = new int[] {582, 200, 100, 25, 270};
        int[] weights = new int[] {18, 5, 14, 0, 12};
        int maxWeights = 30;
        int[] tab = new int[maxWeights+1];
        System.out.println(pack(costs, weights, maxWeights, tab, 0));
    }

    /** Возведение в положительную степень
     * @param num - число
     * @param deg - степень
     * */
    public static int extent (int num, int deg){
        if (deg == 0) {
            return 1;
        }
        else
          if (deg < 0) {
              System.out.println("Степень должна быть >=0");
              return -1000;
          }
          else
          {
              {
                  if (deg == 1) {
                      return num;
                  } else {
                      return num * extent(num, deg - 1);
                  }
              }
          }
    }

    /**Наполнение рюкзака
     * @param pCosts - массив стоимостей предметов
     * @param pWeights - массив весов
     * @param pMaxWeights - максимальный вес
     * @param pTab - результат
     * @param i - индекс прохода
     * */
    public static int pack(int[] pCosts, int[] pWeights, int pMaxWeights, int[] pTab, int i) {
        if(i>=pCosts.length)
        {
            return 0;
        }
        if(pTab[pMaxWeights] != 0)
        {
            return pTab[pMaxWeights];
        }

        int value1 = pack(pCosts, pWeights, pMaxWeights, pTab, i+1);
        int value2 = 0;

        if(pMaxWeights >= pWeights[i])
        {
            value2 = pack(pCosts, pWeights, pMaxWeights-pWeights[i], pTab, i+1) + pCosts[i];
        };

        if (value1>value2) {
            return pTab[pMaxWeights] = value1;
        }
        else
        {
            return pTab[pMaxWeights] = value2;
        }
    }
}
