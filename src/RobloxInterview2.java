import java.util.ArrayList;
import java.util.List;

/*
Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s.

Write a function that takes in the image and returns one of the following representations of the rectangle of 0's:
top-left coordinate and bottom-right coordinate OR
top-left coordinate, width, and height.

image1 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 0, 0, 0, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

Sample output variations (only one is necessary):

findRectangle(image1) =>
  x: 3, y: 2, width: 3, height: 2
  2,3 3,5 -- row,column of the top-left and bottom-right corners

Other test cases:

image2 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

findRectangle(image2) =>
  x: 6, y: 4, width: 1, height: 1
  4,6 4,6

image3 = [
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 0, 0],
  [1, 1, 1, 1, 1, 0, 0],
]

findRectangle(image3) =>
  x: 5, y: 3, width: 2, height: 2
  3,5 4,6

image4 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
]

findRectangle(image4) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0

image5 = [
  [0],
]


image6 = [
[0 1 1
 0 1 1]
]



findRectangle(image5) =>
  x: 0, y: 0, width: 1, height: 1
  0,0 0,0

n: number of rows in the input image
m: number of columns in the input image

*/


class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Point() {}
}


public class RobloxInterview2 {
    public static void main(String[] argv) {
        int[][] image1 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] image2 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0}
        };

        int[][] image3 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 0, 0}
        };

        int[][] image4 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        int[][] image5 = {
                {0}
        };

        List<Point> points = getRectangleCoordinates(image5);
        int[] point1 = getFirstCoordinates(image5);
        int[] point2 = getSecondCorner(point1, image5);

        System.out.println("" + point1[0] + point1[1] + point2[0] + point2[1]);




    }


    static int[] getFirstCoordinates(int[][] image) {
        for (int i = 0 ; i < image.length; i++)
            for(int j = 0; j < image[0].length; j++)
                 if (image[i][j] == 0)
                    return new int[] {i, j};
        return new int[] {0, 0};
    }

    static int[] getSecondCorner(int[] point1, int[][] image) {
            int j, i;
            for(j = point1[1]; j < image[0].length; j++)
                if (image[point1[0]][j] == 1)
                    break;
            if (j > 0) j--;
            for(i = point1[0] + 1; i < image.length; i++)
            if (image[i][j] == 1)
                break;
        return new int[] {i-1, j};
    }


    static List<Point> getRectangleCoordinates(int[][] image) {
        //Find out the first 0
        int rows = image.length;
        int columns = image[0].length;
        Point point1 = new Point();
        boolean foundFirstCorner = false;
        for (int i = 0 ; i < rows ; i++) {
            if (foundFirstCorner) break;
            for (int j = 0 ; j < columns ; j++) {
                if (image[i][j] == 0) {
                    point1.x = i;
                    point1.y = j;
                    foundFirstCorner = true;
                    break;
                }
            }
        }
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(point1);
        points.add(getSecondCorner(point1, image));
        return points;
    }

    static Point getSecondCorner(Point point1, int[][] image) {
        int rows = image.length;
        int columns = image[0].length;
        int j = point1.y + 1;
        int i = point1.x;
        while(j < columns && image[i][j] == 0 ) j++;
        j--;
        while(i < rows && image[i][j] == 0) i++;
        i--;
        return new Point(i, j);
    }
}
