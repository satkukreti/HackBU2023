public class Camera {


    public Camera(double x, double y, double z, double pitch, double roll, double yaw, int width, int height, double fov) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.roll = roll;
        this.yaw = yaw;
        this.width = width;
        this.height = height;
        this.fov = fov;
    }

    public Camera() {
        this(-5, 10, 5, 0, 0, Renderer.rad(0), 100, 100, 10);
    }

    // contains information about the current camera position
    // will take in an array of triangles, and transform them appropriately in three dimensions, returning a list of triangles with two-dimensional coordinates, sorted by z-order
    double x, y, z, pitch, roll, yaw;
    double fov;
    int width, height;

    public double[] convertPoints(double x, double y, double z) {
        //System.out.print(x + "," + y + "," + z);
        double[] output = new double[2];
        double lX = x - this.x, lY = y - this.y, lZ = z - this.z;

        //System.out.print("x " + x + ", y " + y + ", z " + z);

        x = lX * Math.cos(yaw) - lZ * Math.sin(yaw);
        z = lX * Math.sin(yaw) + lZ * Math.cos(yaw);


        lZ = z;
        lX = x;

        y = lY * Math.cos(pitch) - lZ * Math.sin(pitch);
        z = lY * Math.sin(pitch) + lZ * Math.cos(pitch);

        lZ = z;
        lY = y;

        y = lY * Math.cos(roll) - lX * Math.sin(roll);
        x = lY * Math.sin(roll) + lZ * Math.cos(roll);

        //System.out.print(" P: " + x + ","+ y + "," + z + ";");

        output[0] = ((width / 2) + fov * (x) / (z));
        output[1] = ((height / 2) + fov * (y) / (z));
        //System.out.print(" O: " + output[0] + "," + output[1]);

        return output;

    }
}
