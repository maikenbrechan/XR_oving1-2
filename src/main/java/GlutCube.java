

import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.*;

public class GlutCube implements GLEventListener {

    private GLU glu;

    private static String TITLE = "GLUT cube";
    private static final int CANVAS_WIDTH = 320;  // width of the drawable
    private static final int CANVAS_HEIGHT = 240; // height of the drawable
    private static final int FPS = 60; // animator's target frames per second
    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();      // get the OpenGL graphics context
        glu = new GLU();                         // get GL Utilities
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // set background (clear) color
        gl.glClearDepth(1.0f);      // set clear depth value to farthest
        gl.glEnable(GL.GL_DEPTH_TEST); // enables depth testing
        gl.glDepthFunc(GL.GL_LEQUAL);  // the type of depth test to do
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST); // best perspective correction
        gl.glShadeModel(GL2.GL_SMOOTH); // blends colors nicely, and smoothes out lighting
    }
    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {    }
    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
        gl.glLoadIdentity();  // reset the model-view matrix
        GLUT glut = new GLUT();
        gl.glColor3f(1.0f, 0.0f,0.0f);
        glu.gluLookAt(0, 0, 15, 0, 0, 0, 0, 1, 0);
        glut.glutWireCube(5.0f);//The cube is centered at the modeling coordinates origin with sides of length size.
        /*
         * Argumentet er size, så lengdene på hver side!
         * Etterpå må kuben flyttes på for å sentreres i framen
         */
        gl.glEnd(); //forcing gl to draw

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();  // get the OpenGL 2 graphics context

        if (height == 0) height = 1;   // prevent divide by zero
        float aspect = (float)width / height;

        // Set the view port (display area) to cover the entire window
        gl.glViewport(0, 0, width, height);

        // Setup perspective projection, with aspect ratio matches viewport
        gl.glMatrixMode(GL2.GL_PROJECTION);  // choose projection matrix
        gl.glLoadIdentity();             // reset projection matrix
        glu.gluPerspective(45.0, aspect, 0.1, 100.0); // fovy, aspect, zNear, zFar

        // Enable the model-view transform
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity(); // reset
    }

    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final javax.media.opengl.awt.GLCanvas glcanvas = new GLCanvas(capabilities);
        GlutCube glutCube = new GlutCube();
        glcanvas.addGLEventListener(glutCube);
        glcanvas.setSize(400, 400);

        //creating frame
        final JFrame frame = new JFrame ("Glut.wireCube(size) oppg 2B");

        //adding canvas to frame
        frame.getContentPane().add(glcanvas);

        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);
    }
}
