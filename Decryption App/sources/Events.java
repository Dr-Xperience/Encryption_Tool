/****************************************************************************
    Encryption Tool : A set of applications to encrypt or decrypt the file on the basis of the application authorization.
    Copyright (C) 2012  Anubhav Arun <dr.xperience@gmail.com>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

*****************************************************************************/

/** *********************************************************************************
 * TITLE        : THE CLASS TO CONTROL THE APPLICATION EVENTS
 * AUTHOR       : RK10R04A01;11000527;ANUBHAV ARUN GUPTA
 * DATE/TIME    : AD 2012.11.12.12.12
 * EDITOR       : VIM
 * JAVA VERSION : 1.6.0_22
 * JRE          : OpenJDK Runtime Environment (IcedTea6 1.10.3) (fedora-59.1.10.3.fc16-x86_64)
 * VERSION      : $Id: Events.java,v 1.12 2012/11/22 09:12:42 Dr.Xperience Exp Dr.Xperience $
 * ************************************************************************************* */

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Events extends GUI
{
  Encrypt vEny = new Encrypt();
  void make ()
  {
    vPanel = new JPanel();
    vPanel.add(vGenerateButton);
    vFrame.getContentPane ().add (BorderLayout.NORTH, vPanel);

    vPanel = new JPanel ();
    vPanel.add (vEncryptButton);
    vPanel.add (vCloseButton);
    vFrame.getContentPane ().add (BorderLayout.SOUTH, vPanel);

    vPanel = new JPanel ();
    vPanel.add (vInputField);
    vPanel.add (vOutputField);
    vFrame.getContentPane ().add (BorderLayout.CENTER, vPanel);

    vPanel = new JPanel ();
    vPanel.add (vInputButton);
    vPanel.add (vOutputButton);
    vPanel.setLayout (new BoxLayout (vPanel, BoxLayout.Y_AXIS));
    vFrame.getContentPane ().add (BorderLayout.EAST, vPanel);

    vGenerateButton.addActionListener (new vGenerateButton_Click ());

    vDecryptButton.addActionListener (new vDecryptButton_Click ());
    vCloseButton.addActionListener (new vCloseButton_Click ());

    vInputButton.addActionListener (new vInputButton_Click ());
    vOutputButton.addActionListener (new vOutputButton_Click ());


  }


  class vDecryptButton_Click implements ActionListener
  {
    public void actionPerformed (ActionEvent e)
    {
     File vInFile= new File(vInputField.getText());
     File vOutFile= new File(vOutputField.getText());
     vEny.decrypt(vInFile,vOutFile);
    }
  }

  class vGenerateButton_Click implements ActionListener
  {
    public void actionPerformed (ActionEvent e)
    {

      vEny.generateKey();
    }

  }

  class vCloseButton_Click implements ActionListener
  {
    public void actionPerformed (ActionEvent e)
    {

      System.exit (0);
    }

  }
  class vInputButton_Click implements ActionListener
  {
    public void actionPerformed (ActionEvent e)
    {
      int returnVal = vFileChooser.showOpenDialog (null);

      if (returnVal == JFileChooser.APPROVE_OPTION)
	{
	  File vFile = vFileChooser.getSelectedFile ();

    vFileChooser.setFileSelectionMode (JFileChooser.FILES_ONLY);
	    vInputField.setText (vFile.getAbsolutePath());
            vOutputField.setText(vFile.toString()+",1");//vFile.getAbsolutePath());
	}
    }

  }

  class vOutputButton_Click implements ActionListener
  {
    public void actionPerformed (ActionEvent e)
    {
      int returnVal = vFileChooser.showOpenDialog (null);

      if (returnVal == JFileChooser.APPROVE_OPTION)
	{
	  File vFile = vFileChooser.getSelectedFile ();

    vFileChooser.setFileSelectionMode (JFileChooser.DIRECTORIES_ONLY);
	    vOutputField.setText (vFile.getAbsolutePath());
	}


    }

  }
}
