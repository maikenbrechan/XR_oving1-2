import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.*;


public class Figures implements GLEventListener {
    @Override
    public void init(GLAutoDrawable glAutoDrawable) {    }
    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        final GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(0.0f,0.0f,0.0f,0.0f); //Sets the clearing color to black
        gl.glClear(GL.GL_COLOR_BUFFER_BIT); //Then clears the entire buffer to the set clearing color, the clearing color does not need to be set throught the rest of the program
        gl.glLoadIdentity();

        gl.glColor3f(1.0f, 0.0f,0.0f);
        gl.glBegin(GL.GL_POINTS); //starts drawing of points
        gl.glVertex3f(0.0f,2.0f,0.0f);//upper-right corner
        gl.glVertex3f(2.0f,0.0f,0.0f);//lower-left corner
        gl.glEnd();//end drawing of points
        gl.glLoadIdentity();

        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glTranslatef(0.0f, 0.2f,0.0f);
        gl.glBegin(GL2.GL_LINE_STRIP);
        gl.glVertex3f(-1.5f, -1.5f, 0.0f);
        gl.glVertex3f(2.0f, 0.0f, 0.0f);
        gl.glVertex3f(-2.0f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glLoadIdentity();

        gl.glTranslatef(0.5f,0.0f,0.0f);
        gl.glColor3f(1.0f,0.0f,0.0f);
        gl.glBegin (GL2.GL_LINES);//static field
        gl.glVertex3f(0.50f,-0.50f,0f);
        //gl.glVertex3f(-0.50f,0.50f,0f);
        gl.glEnd();
        gl.glLoadIdentity();

        gl.glTranslatef(0.0f,0.0f,-0.2f);
        gl.glColor3f(0.0f,1.0f,0.0f);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3f(0.0f, 2.0f, 0.0f);
        gl.glVertex3f(1.5f, 1.5f, 0.0f);
        gl.glVertex3f(1.5f, -1.5f, 0.0f);
        gl.glVertex3f(0.0f, -2.0f, 0.0f);
        gl.glEnd();
        gl.glLoadIdentity();

        //gl.glClearColor(0.0f,0.0f,0.0f,0.0f);
        gl.glTranslatef(0.0f,0.0f,0.0f);
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex3f(1.5f, 1.5f, 0.0f);
        gl.glVertex3f(0.0f, 2.0f, 0.0f);
        gl.glVertex3f(-2.0f, 0.0f, 0.0f);
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {    }

    public static void main(String[] args) {
        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);

        glcanvas.addGLEventListener(new Figures());

        glcanvas.setSize(5000, 2000);

        //creating frame
        final JFrame frame = new JFrame ("straight Line");

        //adding canvas to frame
        frame.getContentPane().add(glcanvas);

        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }
}
