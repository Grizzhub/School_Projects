/**
Author: Jason
This Project displays the cafe wall illusion by using rows of black squares and 
a gray line between them.
**/
#include<gl/glut.h>

void drawByItteration(int x1, int x2, int y, bool isOddItteration) {
    if (isOddItteration) {
        glVertex2i(x1, y);
        glVertex2i(x2, y);
    } else {
        glVertex2i(x2, y);
        glVertex2i(x1, y);
    }
}
  void draw(int x) {
    bool isOddItteration = true;
    for (int y = 0; y <= 250; y+=50) {
        drawByItteration(x + 25, x + 75, y, isOddItteration);
        isOddItteration = !isOddItteration;
    }
    isOddItteration = true;
    for (int y = 50; y <= 300; y+=50) {
        if (y == 150 || y == 200) {
            drawByItteration(x + 50, x + 100, y, isOddItteration);
        } else {
            drawByItteration(x, x + 50, y, isOddItteration);
        }
        isOddItteration = !isOddItteration;
    }
}
    
  void drawSquares() {
        for (int x = 0; x <= 400; x+=100) {
              draw(x);
         }	
    }

void display(void){
	glClear(GL_COLOR_BUFFER_BIT);
	 glColor3f(0.0, 0.0, 0.0); // black
	 glBegin(GL_QUADS);

	 drawSquares(); // draw squares call

	 glEnd();	
	
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
