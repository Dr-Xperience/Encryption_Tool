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

/** ********************************************************************************
 * TITLE	: PROJECT TESTER
 * AUTHOR	: 11000527;RK1R04A01;ANUBHAV ARUN GUPTA
 * VERSION	: $Id: MainClass.java,v 1.2 2012/11/16 17:18:36 Dr.Xperience Exp Dr.Xperience $
 * EDITOR       : VIM
 * JAVA VERSION : 1.6.0_22
 * JRE          : OpenJDK Runtime Environment (IcedTea6 1.10.3) (fedora-59.1.10.3.fc16-x86_64)
 * ******************************************************************************** */

class MainClass
{
  public static void main( String arg[])
  {
   Events vGui= new Events();
   vGui.frameBeg("Encrption App");
   vGui.make();
   vGui.frameEnd();
  }
}
