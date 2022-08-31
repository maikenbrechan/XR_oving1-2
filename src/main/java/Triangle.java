import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.*;

public class Triangle implements GLEventListener {

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT); //Clear the screen and the depth buffer
        gl.glLoadIdentity();

        //gl.glTranslatef(-1.5f, 0.0f, -8.0f); // Move left 1.5 Units and 7 units into the screen
        gl.glColor3f(1.0f, 0.0f, 0.0f);      // Set the color to red

        gl.glBegin(GL2.GL_TRIANGLES);          // Start drawing using the polygon primitive GL_TRIANGLES
        gl.glVertex3f(0.0f, 1.0f, 0.0f);   // Top
        gl.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom left
        gl.glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom right
        gl.glEnd();                        // Finished drawing the triangle
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    public static void main(String[] args) {

        //getting the capabilities object of GL2 profile
        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        Triangle triangle = new Triangle();
        glcanvas.addGLEventListener(triangle);
        glcanvas.setSize(400, 400);

        //creating frame
        final JFrame frame = new JFrame ("straight Line");

        //adding canvas to frame
        frame.getContentPane().add(glcanvas);

        frame.setSize(frame.getContentPane().getPreferredSize());
        frame.setVisible(true);

    }//end of main
}
