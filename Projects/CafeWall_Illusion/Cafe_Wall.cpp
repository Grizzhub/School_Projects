/**
Author: Jason
This Project displays the cafe wall illusion by using rows of black squares and 
a gray line between them.
**/
#include<gl/glut.h>

void display(void){
	glClear(GL_COLOR_BUFFER_BIT);
	 glColor3f(0.0, 0.0, 0.0); // black

		for(int x = 0;x<=500;x += 75){ // I chose this for loop because I wanted to shift the x by 75 each iteration
			glBegin(GL_QUADS);
			//Creating the first black square position at the top left
			glVertex2i(x, 300); 
			x+=50;
            	    glVertex2i(x, 300); 
            	    glVertex2i(x, 250);
			x-=50;
            	    glVertex2i(x, 250);

			x+=25; // Shifting the second black square that will go below it over by 25 in the x dimension
			
			//Second black square that goes below the first
			glVertex2i(x, 250);
			x+=50;
            	     glVertex2i(x, 250);
            		glVertex2i(x, 200);
			x-=50;
            		glVertex2i(x, 200);

			x+=25; // Shifting the third black square over slightly to go below the second

			//Third black square that goes below the second
			glVertex2i(x, 200);
			x+=50;
            		glVertex2i(x, 200);
            		glVertex2i(x, 150);
			x-=50;
            		glVertex2i(x, 150);

			x-=25; //Shifting the fourth square backwards to to alternate

			//Fourth black square
			glVertex2i(x, 150);
			x+=50;
            		glVertex2i(x, 150);
            		glVertex2i(x, 100);
			x-=50;
            		glVertex2i(x, 100);

			x-=25; // Shift backwards

			//Fifth square
			glVertex2i(x, 100);
			x+=50;
            		glVertex2i(x, 100);
            		glVertex2i(x, 50);
			x-=50;
            		glVertex2i(x, 50);

			x+=25; // Shift forwards again

			// Last square
			glVertex2i(x, 50);
			x+=50;
            		glVertex2i(x, 50);
            		glVertex2i(x, 0);
			x-=50;
            		glVertex2i(x, 0);

			glEnd(); // end quads
		}
	
	glBegin(GL_LINES); //declare lines
	glColor3f(0.5, 0.5, 0.5); // gray
	int y = 250; // want to gray line to go between where the boxes are
	for(int i = 0;i<6;i++){ // want 6 lines total
			glVertex2i(0,y);
			glVertex2i(425,y);
			y-=50; // The line goes between each row of boxes
	}

	glEnd();
	glFlush();
}

void main(int argc, char * * argv){
	glutInit(&argc,argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(425,300);
	glutInitWindowPosition(200,100);
	glutCreateWindow("The Cafe Wall Illusion");
	glClearColor(1.0,1.0,1.0,0.0);
	gluOrtho2D(0.0 ,425.0 ,0.0 ,300.0);
	glutDisplayFunc(display);
	glutMainLoop();
}
