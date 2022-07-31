import java.awt.*;

public abstract class GameObject {

    protected Image img;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    //速度
    protected double speed;
    //引入主界面
    protected GameWin frame;

    public GameObject(){

    }

    public GameObject(String img, GameWin frame) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.frame = frame;
    }

    public GameObject(String img, int x, int y, double speed, GameWin frame) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.frame = frame;
    }

    public GameObject(String img, int x, int y, int width, int height, double speed, GameWin frame) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.frame = frame;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameWin getFrame() {
        return frame;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }
    //继承元素绘制自己的方法
    public abstract void paintSelf(Graphics g);

    //获取当前游戏元素的矩形,碰撞检测
    public abstract Rectangle getRec();
}
