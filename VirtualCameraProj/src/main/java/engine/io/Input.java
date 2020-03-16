package engine.io;

import org.lwjgl.glfw.*;

public class Input {
    private static boolean[] keys;
    private static boolean[] buttons;
    private static double mouseX, mouseY;
    private static double scrollX, scrollY;

    private GLFWKeyCallback keyboard;
    private GLFWCursorPosCallback mouseMove;
    private GLFWMouseButtonCallback mouseButtons;
    private GLFWScrollCallback mouseScroll;

    public Input() {
        keys = new boolean[GLFW.GLFW_KEY_LAST];
        buttons = new boolean[GLFW.GLFW_MOUSE_BUTTON_LAST];
        keyboard = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scanCode, int action, int mods) {
                keys[key] = (action != GLFW.GLFW_RELEASE);
            }
        };

        mouseMove = new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double xpos, double ypos) {
                mouseX = xpos;
                mouseY = ypos;

            }
        };

        mouseButtons = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                buttons[button] = (action != GLFW.GLFW_RELEASE);
            }
        };

        mouseScroll = new GLFWScrollCallback() {
            @Override
            public void invoke(long window, double offsetX, double offsetY) {
                scrollX += offsetX;
                scrollY += offsetY;
            }
        };
    }

    public static boolean isKeyDown(int key) {
        return keys[key];
    }

    public static boolean isButtonDown(int button) {
        return buttons[button];
    }

    public void destroy() {
        keyboard.free();
        mouseMove.free();
        mouseButtons.free();
        mouseScroll.free();
    }

    public double getMouseX() {
        return mouseX;
    }

    public void setMouseX(double mouseX) {
        this.mouseX = mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public void setMouseY(double mouseY) {
        this.mouseY = mouseY;
    }

    public GLFWKeyCallback getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(GLFWKeyCallback keyboard) {
        this.keyboard = keyboard;
    }

    public GLFWCursorPosCallback getMouseMove() {
        return mouseMove;
    }

    public void setMouseMove(GLFWCursorPosCallback mouseMove) {
        this.mouseMove = mouseMove;
    }

    public GLFWMouseButtonCallback getMouseButtons() {
        return mouseButtons;
    }

    public void setMouseButtons(GLFWMouseButtonCallback mouseButtons) {
        this.mouseButtons = mouseButtons;
    }

    public static double getScrollX() {
        return scrollX;
    }

    public static void setScrollX(double scrollX) {
        Input.scrollX = scrollX;
    }

    public static double getScrollY() {
        return scrollY;
    }

    public static void setScrollY(double scrollY) {
        Input.scrollY = scrollY;
    }

    public GLFWScrollCallback getMouseScroll() {
        return mouseScroll;
    }
}
