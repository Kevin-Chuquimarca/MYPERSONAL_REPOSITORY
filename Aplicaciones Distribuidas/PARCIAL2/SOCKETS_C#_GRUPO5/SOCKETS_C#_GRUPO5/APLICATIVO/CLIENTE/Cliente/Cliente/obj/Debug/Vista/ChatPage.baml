   M S B A M L   `   `   `  ����B  >Cliente, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null-clr-namespace:Cliente.VistaCliente.Vista  5      7 clr-namespace:Cliente.ComponentsCliente.Components  5          Cliente.Vista.ChatPage   5      R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35D 9http://schemas.microsoft.com/winfx/2006/xaml/presentation    5      R NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5      Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5      @d2http://schemas.microsoft.com/expression/blend/2008     5      -localclr-namespace:Cliente.Vista     5      /uc clr-namespace:Cliente.Components     5        N� Title$  ChatPage��5
       � 	Resources 5       �� 
TargetType   btn �� Triggers P� Property P� Value �� Property �� Value  message-primary �� ElementName  message-primary-content  message-secondary  message-secondary-content��%�  &	        &	 �     &	 �    &	 o    &	 {    �� 5   
   " ��6    5      P� 5       �@J�IsMouseOver . . �5      ��  � ��
 ���� 6I   5      5      �� 5   
   " ��6   .�5      ��  � �� �#2196f36=   �� 5       �@��CornerRadius$ 
20,20,0,20��6-   6B   �� 5       � ��$ 50,20,20,20q�6'   6=   �� 5       � �� 6)   �� *ActualWidth+$ Chat_Content��6c   5      �� 5   
   " ��6   .�5      ��  � �� �#ffffff6=   �� 5       � ��$
 Wrap=�6-   6<   �� 5       � ��$ 20q�6'   64   �� 5       �@��TextAlignment$ Right=�6.   6>   5      �� 5!   
   " ��6   .�5"      ��  � �� �	#0D0000006?   �� 5#       �@��CornerRadius$ 
20,20,20,0��6-   6B   �� 5$       � ��$ 20,20,50,20q�6'   6=   �� 5%       � �� 6)   �� *ActualWidth+$ Chat_Content��6c   5&      �� 5'   
   " ��6   .�5(      ��  � �� �#0000006=   �� 5)       � ��$
 Wrap=�6-   6<   �� 5*       � ��$ 20q�6'   64   �� 5+       �@��TextAlignment$
 Left=�6.   6=   5,      5-      .��5/      ]� .+�50   
   � -   5        $��UsersContainer��50   1   $
��Left=�6   $	��200��6%   ���#eceff1	 � ColumnDefinitions	 51      �� 52      $
��60px �6#   �� 53      $��140px �6#   
 � RowDefinitions
 55      �� 56      $
��Auto �6    .+�59      �� $��0��6   $��2��6$   $��0��68   $��Center=�6E   $��14(�6b   .��6p   
Usuarios6z   5;      �� 5<   
   -   5        $��Username��5<   3   $	��Top=�6   $��16(�6%   6E   ]� 5>   
   $��Bottom=�6   $��49��6,   .+�5?      �� $��Right=�6   
������ $��0q�6E   #��[  6Y   .��5@      �� $��24��6   $��../images/send.png��6#   6A   5A         Cliente.Components.Input  5B      -   5          Name$ msgInput��5B      $	��424��6*   $��40��66   "   Cliente.Components.InputFile  5C      -   5          Name$ 	fileInput��5C   3   $	��122��6   $��34��6'   63   5D      �� 5F   
   -   5        $��Chat_Content��5F   `   ��.  $
��Auto��60   $
��Auto=�6=   $	��381��6t   .��5G      �� -   5        $��MessagesPanel��5G      5J      5K      5M      5N      