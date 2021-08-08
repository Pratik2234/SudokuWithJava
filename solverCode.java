package sudocode;

import javax.swing.*;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.Font;

import java.awt.Toolkit;

import java.awt.event.*;


public class solverCode  extends JFrame {

	 public static int count=0;
	
	public solverCode(String s) {
		// TODO Auto-generated constructor stub
		
		super(s);
		
	}
	
	public static boolean isSafe(int[][] board ,int row,int col,int num) {
		
		
		
		// to check value in row
		
		for(int r=0;r<9;r++) {
			
			
			// if the number is present return false
			
			if(board[row][r]==num) {
				
				return false;
				
			}
			
		}
		
		// to check value in column
		
		for(int c=0;c<9;c++) {
			
			//if the number is present in the column
			
			if(board[c][col]==num) {
				
				return false;
				
				}
		}
		
		// to check in the box 
		
		int boxrow=row-row%3;
		
		int boxcol=col-col%3;
		
		for(int r=boxrow;r<boxrow+3;r++) {
			
			
			for(int c=boxcol;c<boxcol+3;c++) {
				
				
				if(board[r][c]==num) {
					
					return false;
				}
				
				
			} 
		}
			
			
		return true;
	}
	
	public static  boolean solve(int[][] board ,int n) {
		
		
		int row=-1;
		
		int col=-1;
		
		boolean isEmpty=true;
		
		//to find empty location in sudoku
		
		for(int i=0;i<n;i++) {
			
			
			for(int j=0;j<n;j++) {
				
				
				
				if(board[i][j]==0) {
					
					row=i;
					
					col=j;
					
					
					isEmpty=false;
					
					break;
				}
				
			} 
		  if(!isEmpty) {
			
			break;
			
	 	  } 
		}
		
		// no empty spaces are remaining
		
		if(isEmpty) {
			
			return true;
			
		}
		
		// to find appropriate value for empty space and backtracking
		
		for(int num=1;num<10;num++) {
			
			if(isSafe(board, row, col, num)) {
				
				board[row][col]=num;
				
				if(solve(board, n)) {
					
					
					return true;
					
				}
				
				else {
					
					board[row][col]=0;
					
				}
				
			}
			
		}
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		JFrame f1=new JFrame("Sudoku_Solver");
		
		f1.setSize(470,600);
		
		JTextField[][] j1=new JTextField[9][9];

		JButton b1=new JButton("Validate");
		
		b1.setBounds(50,460,100,40);
		
		Font f2=new Font("Verdana",Font.BOLD,15);
				
	    b1.setFont(f2);
		
		b1.setBackground(Color.black);
		
		b1.setForeground(Color.white);
		
		f1.add(b1);
		
		JButton b2=new JButton("Solve");
		
        b2.setBounds(250,460,100,40);
		
		Font f4=new Font("Verdana",Font.BOLD,15);
				
	    b2.setFont(f4);
		
		b2.setBackground(Color.black);
		
		b2.setForeground(Color.white);
		
		f1.add(b2);
		
		int l=0;
		
		int t=0;
		
	    for(int i=0;i<9;i++) {
		
	    	for (int j=0;j<9;j++) {

	    		Font f=new Font("Verdana",Font.BOLD,40);
	    		
	    		j1[i][j]=new JTextField();

		        j1[i][j].setBounds(l, t, 50, 50);
		        
		        j1[i][j].setFont(f);
		        
		        j1[i][j].setForeground(Color.white);
		        
		        j1[i][j].setBackground(Color.black);
		        
		        l=l+50;
		       
		        f1.add(j1[i][j]);
		   
	    	}
			
	    	t=t+50;
	    	l=0;
		}
		
	    int[][] board = new int[][] {
	    	
	    	{3,0,6,5,0,8,4,0,0},
	    	{5,2,0,0,0,0,0,0,0},
	    	{0,8,7,0,0,0,0,3,1},
	    	{0,0,3,0,1,0,0,8,0},
	    	{9,0,0,8,6,3,0,0,5},
	    	{0,5,0,0,9,0,6,0,0},
	    	{1,3,0,0,0,0,2,5,0},
	    	{0,0,0,0,0,0,0,7,4},
	    	{0,0,5,2,0,6,3,0,0}
	    };
	    
	    for(int k=0;k<9;k++) {
	    	
	    	for (int m=0;m<9;m++) {

	    	
	    		if(board[k][m]==0) {
	    			
	    			
	    			continue;
	    		}
	    		
	    		else {
	    			
	    			j1[k][m].setText(Integer.toString(board[k][m]));
	    			
	    		}
	    		
	    	}
	    	
	    }
	    
	   
	    System.out.println(f1);
	    
	    int N=board.length;
	    
	    if(solve(board,N)==true) { 
	    
	    for(int i=0;i<9;i++) {
	    	
		    	
	    	for (int j=0;j<9;j++) {

		    	 System.out.print(board[i][j]);
                 System.out.print(" ");	    	
		    }
	    	
	    	System.out.println();
	    	
	    }
	    
	   }
	    
        class Validate implements ActionListener{
			
			
        	public boolean isNum(String s){
				
				
				try {
					
					Integer.parseInt(s);
				
				}catch(Exception e) {
					
					return false;
				}
				
					
					return true;			
			}
			
        	
			public void actionPerformed( ActionEvent e) {
		
				int count=0;
				
				JTextField z=new JTextField();
				
				z.setBounds(80,520,125,40);
				
				Font f3=new Font("Verdana",Font.BOLD,15);
						
			    z.setFont(f3);
				
				z.setForeground(Color.white);
				
				z.setBackground(Color.black);
				
					
              
			outer:	for(int i=0;i<9;i++) {
					
					for(int j=0;j<9;j++) {
						
						int k=0;
						
						if(isNum(j1[i][j].getText()))
							k=Integer.parseInt(j1[i][j].getText());
						else
							k=0;
					
						
						if(board[i][j]!=k) {
							
							z.setText("You are wrong");
								
						    f1.add(z);
							
							f1.setVisible(true);
                          
							count=count+1;
							
							break outer;
							
							
						
						}
				}				
			}
				
				if(count==0) {
					
					z.setText("You are Correct");
					
					f1.add(z);
					
					f1.setVisible(true);
					
				}
			}
		}

        
        class SudokuSolver implements ActionListener,Runnable{
        	
      
        	public void actionPerformed(ActionEvent e) {
        			       	
        		run();
        	}
        	
            public boolean isNum(String s){
				
				
				try {
					
					Integer.parseInt(s);
				
				}catch(Exception e) {
					
					return false;
				}
				
					
					return true;			
			}
		
        	@Override
        	public void run() {
        		// TODO Auto-generated method stub
        			
        		for(int i=0;i<9;i++) {
        			
        			
        			for(int j=0;j<9;j++) {
        				
        				
                        int k=0;
						
						if(isNum(j1[i][j].getText()))
							k=Integer.parseInt(j1[i][j].getText());
						else
							k=0;
					
						
						if(board[i][j]==k) {
					
        				
        				continue;
        					
        				}
						else {
							
							j1[i][j].setText(Integer.toString(board[i][j]));
							
							try {
							
							Thread.sleep(20);
							
							}catch (Exception e) {
								// TODO: handle exception
								
								System.out.println("ok");
							}
							
						}
        				
        			}
        			
        			
        		}
        	
        	
        	
        	}
        	
        }
    
	    Validate v=new Validate();
	    
	    b1.addActionListener(v);
	    
	    SudokuSolver s=new SudokuSolver();
	    
	    b2.addActionListener(s);
	    
		f1.setLayout(null);
        
        f1.setVisible(true);
        
        f1.setLocationRelativeTo(null);
        
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		
	}

}