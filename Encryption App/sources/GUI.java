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
 * TITLE 	: THE CLASS TO CONTROL THE APPLICATION GUI
 * AUTHOR	: RK10R04A01;11000527;ANUBHAV ARUN GUPTA
 * DATE/TIME	: AD 2012.11.12.12.12
 * EDITOR	: VIM
 * JAVA VERSION	: 1.6.0_22
 * JRE		: OpenJDK Runtime Environment (IcedTea6 1.10.3) (fedora-59.1.10.3.fc16-x86_64)
 * VERSION	: $Id: GUI.java,v 1.11 2012/11/22 07:45:03 Dr.Xperience Exp $
 * *********************************************************************************** */

import javax.swing.*;
import java.awt.*;

public class GUI
{

  JFrame vFrame;
  JPanel vPanel;


  public void frameBeg (String vTitle)
  {
    vFrame = new JFrame (vTitle);
    vFrame.setUndecorated (true);
    //vFrame.getRootPane ().setWindowDecorationStyle (JRootPane.FRAME);
    vFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    vFrame.setBounds (200, 200, 350, 150);
    vFrame.setResizable (false);
    vFrame.setVisible (true);
  }
/*
  public void frameEnd ()
  {
    vFrame.setBounds (200, 200, 350, 150);
    vFrame.setResizable (false);
    vFrame.setVisible (true);
  }
*/
  JButton vEncryptButton = new JButton ("Encrypt");

  JButton vCloseButton = new JButton ("Close");

  JButton vInputButton = new JButton ("Input");

  JButton vOutputButton = new JButton ("Output");

 // JButton vGenerateButton = new JButton("GenerateKeys");

  JTextField vInputField = new JTextField (20);

  JTextField vOutputField = new JTextField (20);

  JFileChooser vFileChooser = new JFileChooser ();
}
