package Component;

public class AffineTransformation {
    public static Image translate(Image image, int intVariableX, int intVariableY) throws LogicalError {
        int intNewWidth = image.getWidth() + intVariableX;
        int intNewHeight = image.getHeight() + intVariableY;
        Image imageNew = new Image(intNewWidth, intNewHeight);

        double[][] arrScalingMatrix = {
                {1.0, 0.0, -intVariableX},
                {0.0, 1.0, -intVariableY},
                {0.0, 0.0, 1.0            },
        };
        for (int intY = 0; intY < intNewHeight; intY++) {
            for (int intX = 0; intX < intNewWidth; intX++) {
                double[][] arr2NewImagePosition = {
                    {intX},
                    {intY},
                    {1.0}
                };
                double[][] arr2CorrespondPosition = multiplyMatrixs(
                    arrScalingMatrix, arr2NewImagePosition
                );
                int intCorrespondX = (int) arr2CorrespondPosition[0][0];
                int intCorrespondY = (int) arr2CorrespondPosition[1][0];

                if (imageNew.isSizeInRange(intCorrespondX, intCorrespondY))
                    imageNew.setColor(
                        intX, intY, image.getColor(intCorrespondX, intCorrespondY)
                    );
            }
        }

        ColorRGB colorRGB = new ColorRGB();
        colorRGB.setAlpha(256);
        colorRGB.setRed(256);
        image.fillColor(colorRGB);

        return imageNew;
    }

    public static Image scale(Image image, double doubleVariableX, double doubleVariableY) throws LogicalError {
        int intNewWidth = (int)(image.getWidth() * doubleVariableX);
        int intNewHeight = (int)(image.getHeight() * doubleVariableY);
        Image imageNew = new Image(intNewWidth, intNewHeight);

        double[][] arrScalingMatrix = {
            {1 / doubleVariableX, 0.0                , 0.0},
            {0.0                , 1 / doubleVariableY, 0.0},
            {0.0                , 0.0                , 1.0},
        };
        for (int intY = 0; intY < intNewHeight; intY++){
            for (int intX = 0; intX < intNewWidth; intX++){
                double[][] arr2NewImagePosition = {
                    {intX},
                    {intY},
                    {1.0}
                };
                double[][] arr2CorrespondPosition = multiplyMatrixs(
                    arrScalingMatrix, arr2NewImagePosition
                );

                imageNew.setColor(
                    intX,
                    intY,
                    image.getColorByBilinearInterpolation(
                        arr2CorrespondPosition[0][0], arr2CorrespondPosition[1][0]
                    )
                );
            }
        }

        return imageNew;
    }

    public static void shear(){

    }

    public static void rotate(){

    }


    private static double[][] multiplyMatrixs(double[][] matrix01, double[][] matrix02) throws LogicalError {
        if (matrix01[0].length != matrix02.length)
            throw new LogicalError("Multiplying matrixs with mismatched sizes");
        double[][] matrixResult = new double[matrix01.length][matrix02[0].length];

        for (int intY = 0; intY < matrixResult.length; intY++){
            for (int intX = 0; intX < matrixResult[0].length; intX++){
                for (int intPivot = 0; intPivot < matrix01[0].length; intPivot++){
                    matrixResult[intY][intX] += matrix01[intY][intPivot] * matrix02[intPivot][intX];
                }
            }
        }

        return matrixResult;
    }
}
