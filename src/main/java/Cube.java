import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.*;

/**
 * GL_LINE_LOOP
 */

public class Cube implements GLEventListener {
    private GLU glu;

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
    public void display(GLAutoDrawable glAutoDrawable) {
    final GL2 gl = glAutoDrawable.getGL().getGL2();
    GLU glu = new GLU();
    gl.glLoadIdentity();
    //glu.gluLookAt(0, 0, 15, 0, 0, 0, 0, 1, 0);
    //gl.glTranslatef(0.5f,0.3f,-0.2f);
    gl.glColor3f(1.0f,0.0f,0.0f);
    gl.glBegin(GL2.GL_LINE_LOOP);

    // Top-face
    gl.glColor3f(0.0f, 1.0f, 0.0f); // green
    gl.glVertex3f(1.0f, 1.0f, -1.0f);
    gl.glVertex3f(-1.0f, 1.0f, -1.0f);
    gl.glVertex3f(-1.0f, 1.0f, 1.0f);
    gl.glVertex3f(1.0f, 1.0f, 1.0f);

    // Bottom-face
    gl.glColor3f(1.0f, 0.5f, 0.0f); // orange
    gl.glVertex3f(1.0f, -1.0f, 1.0f);
    gl.glVertex3f(-1.0f, -1.0f, 1.0f);
    gl.glVertex3f(-1.0f, -1.0f, -1.0f);
    gl.glVertex3f(1.0f, -1.0f, -1.0f);

    // Front-face
    gl.glColor3f(1.0f, 0.0f, 0.0f); // red
    gl.glVertex3f(1.0f, 1.0f, 1.0f);
    gl.glVertex3f(-1.0f, 1.0f, 1.0f);
    gl.glVertex3f(-1.0f, -1.0f, 1.0f);
    gl.glVertex3f(1.0f, -1.0f, 1.0f);

    // Back-face
    gl.glColor3f(1.0f, 1.0f, 0.0f); // yellow
    gl.glVertex3f(1.0f, -1.0f, -1.0f);
    gl.glVertex3f(-1.0f, -1.0f, -1.0f);
    gl.glVertex3f(-1.0f, 1.0f, -1.0f);
    gl.glVertex3f(1.0f, 1.0f, -1.0f);

    // Left-face
    gl.glColor3f(0.0f, 0.0f, 1.0f); // blue
    gl.glVertex3f(-1.0f, 1.0f, 1.0f);
    gl.glVertex3f(-1.0f, 1.0f, -1.0f);
    gl.glVertex3f(-1.0f, -1.0f, -1.0f);
    gl.glVertex3f(-1.0f, -1.0f, 1.0f);

    // Right-face
    gl.glColor3f(1.0f, 0.0f, 1.0f); // violet
    gl.glVertex3f(1.0f, 1.0f, -1.0f);
    gl.glVertex3f(1.0f, 1.0f, 1.0f);
    gl.glVertex3f(1.0f, -1.0f, 1.0f);
    gl.glVertex3f(1.0f, -1.0f, -1.0f);

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
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        Cube cube = new Cube();
        glcanvas.addGLEventListener(cube);

        glcanvas.setSize(5000, 2000);

        //creating frame
        final JFrame frame = new JFrame ("cube 2a");

        //adding canvas to frame
        frame.getContentPane().add(glcanvas);

        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }
}
