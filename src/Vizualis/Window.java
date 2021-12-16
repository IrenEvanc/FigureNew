package Vizualis;

import Creator.*;
import Figures.Figure;
import Figures.Triangle;
import com.company.Point;
import menu.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static com.company.Main.file;

public class Window extends JFrame implements ActionListener {
    private final ArrayList<Figure> figures;
    private  ArrayList<Figure> fig;
    private Graph canvas;
    private JPanel panel;
    private JFrame addFigure;
    private Font font;
    boolean chooseFigure = false;
    double angle, scale;
    Point vect;
    JButton b1, b5;

    Figure activeFigure = null;

    private ArrayList<JTextField> xText, yText;
    private ArrayList<JLabel> l1, l2;

    public Window(ArrayList<Figure> figures) {
        super("Графический редактор");
        this.figures = figures;
        this.setSize(800, 700);
        this.setResizable(false);
        this.canvas = new Graph(figures);

        this.panel = new JPanel();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.font = new Font("Verdana", Font.ITALIC, 16);
//        setExtendedState(MAXIMIZED_BOTH);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createButtonMenu());
        setJMenuBar(menuBar);

        setVisible(true);
    }

    private JMenu createFileMenu() {
        JMenu carte = new JMenu("Файл");
        carte.setFont(font);
        JMenuItem open = new JMenuItem("Открыть");
        JMenuItem exit = new JMenuItem(new ExitAction());
        JMenuItem save = new JMenuItem("Сохранить");
        carte.add(open);
        carte.addSeparator();
        carte.add(save);
        carte.addSeparator();
        carte.add(exit);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Menu.saveToFile(figures,file);
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Menu.initFromFile(file);
                canvas.repaintGraph(figures);
            }
        });
        return carte;
    }

    private JMenu createButtonMenu() {
        JMenu file = new JMenu("Команды");
        file.setFont(font);
        JMenuItem output = new JMenuItem("Вывести все фигуры");
        output.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                ActionEvent.ALT_MASK));
        output.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Container c = getContentPane();

                c.remove(canvas);
                canvas.repaintGraph(figures);
                c.add(canvas);
                setVisible(true);
                c.revalidate();
            }
        });
        file.add(output);
        file.add(new JSeparator());

        JMenuItem add = new JMenuItem("Добавить фигуру");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                selectionWindow();
            }
        });
        file.add(add);
        file.add(new JSeparator());
        JMenuItem select = new JMenuItem("Выбрать фигуру");
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                chooseFigure = true;

                canvas.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int x = e.getX()-canvas.getWidth()/2;
                        int y = -(e.getY()-canvas.getHeight()/2);

                        activeFigure = defineFigureByCursor(x, y, canvas.multiplier, figures);
                        if (chooseFigure && activeFigure != null) {
                            JOptionPane.showMessageDialog(null, "Фигура выбрана", "title", JOptionPane.PLAIN_MESSAGE);
                            fig = new ArrayList<>();
                            fig.add(activeFigure);
                            canvas.repaintGraph(fig);
                            chooseFigure = false;
                        }
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }
                   @Override
                    public void mouseEntered(MouseEvent e) {
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });
            }
        });

        file.add(select);

        file.add(new JSeparator());
        JMenu change = new JMenu("Изменить фигуру");

        JMenuItem itm = new JMenuItem("Поворот фигуры");
        itm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                rotateFigure();
            }
        });
        change.add(itm);

        itm = new JMenuItem("Перемещение фигуры");
        itm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        itm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                moveFigure();
            }
        });
        change.add(itm);

        itm = new JMenuItem("Масштабирование фигуры");
        itm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                scaleFigure();
            }
        });
        change.add(itm);

        file.add(change);
        file.add(new JSeparator());

        JMenuItem delete = new JMenuItem("Удалить фигуру");
        output.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.ALT_MASK));
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                deleteFigure();
            }
        });

        file.add(delete);
        file.add(new JSeparator());
        return file;
    }

    class ExitAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        ExitAction() {
            putValue(NAME, "Выход");
        }

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public Figure defineFigureByCursor(int x, int y, int multiplier, ArrayList<Figure> figures) {
        for (Figure f : figures) {
            if (f.containPoint(x, y, multiplier)) return f;
        }
        return null;
    }

    public void rotateFigure() {
        JFrame rotateFigure = new JFrame("Поворот фигуры");
        rotateFigure.setSize(350, 500);
        rotateFigure.setResizable(false);
        rotateFigure.setVisible(true);
        Container g = rotateFigure.getContentPane();

        g.setLayout(new FlowLayout());
        JLabel rotate = new JLabel(" Введите угол поворота: ");
        JTextField rotateText = new JTextField(20);
        JButton b2 = new JButton("Ок");
        rotateFigure.add(rotate);
        rotateFigure.add(rotateText);
        rotateFigure.add(b2);
        setVisible(true);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2) {
                    angle = Double.valueOf(rotateText.getText());
                    activeFigure.rotate(angle);
                    canvas.repaintGraph(fig);
                    rotateFigure.removeAll();
                    rotateFigure.revalidate();
                }
            }});

    }
    public void scaleFigure() {
        JFrame scaleFigure = new JFrame("Поворот фигуры");
        scaleFigure.setSize(350, 500);
        scaleFigure.setResizable(false);
        scaleFigure.setVisible(true);
        Container g = scaleFigure.getContentPane();

        g.setLayout(new FlowLayout());
        JLabel scaleFig = new JLabel("Изменить фигуру в: ");
        JTextField scaleText = new JTextField(20);
        JButton b3 = new JButton("Ок");
//        Font font = new Font("Verdana", Font.PLAIN, 18); шрифт
        scaleFigure.add(scaleFig);
        scaleFigure.add(scaleText);
        scaleFigure.add(b3);
        setVisible(true);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3) {
                    scale = Double.valueOf(scaleText.getText());
                    activeFigure.scale (scale);
                    canvas.repaintGraph(fig);
                    scaleFigure.removeAll();
                    scaleFigure.revalidate();
                }
            }});

    }
    public void moveFigure() {
        JFrame moveFigure = new JFrame("Поворот фигуры");
        moveFigure.setSize(200, 500);
        moveFigure.setResizable(false);
        moveFigure.setVisible(true);
        Container g = moveFigure.getContentPane();

        g.setLayout(new FlowLayout());
        JLabel moveFig = new JLabel("Переместить фигуру на");
        JLabel X = new JLabel("     Х =    ");
        JLabel Y = new JLabel("     Y =    ");

        JTextField scaleTextX = new JTextField(10);
        JTextField scaleTextY = new JTextField(10);

        JButton b3 = new JButton("                  Ок                  ");
        moveFigure.add(moveFig);
        moveFigure.add(X);
        moveFigure.add(scaleTextX);
        moveFigure.add(Y);
        moveFigure.add(scaleTextY);
        moveFigure.add(b3);
        setVisible(true);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3) {
                    vect =new Point(Double.valueOf(scaleTextX.getText()),Double.valueOf(scaleTextY.getText())) ;
                    activeFigure.scale (scale);
                    canvas.repaintGraph(fig);
                    moveFigure.removeAll();
                    moveFigure.revalidate();
                }
            }});

    }
    public void deleteFigure() {
        JFrame deleteFigure = new JFrame();
        deleteFigure.setSize(300, 500);
        deleteFigure.setResizable(false);
        deleteFigure.setVisible(true);
        Container g = deleteFigure.getContentPane();

        g.setLayout(new FlowLayout());
        JLabel deleteFig = new JLabel("Вы действительно хотите удалить?");

        JButton b3 = new JButton("                  Да                  ");
        JButton b2 = new JButton("                  Нет                  ");

//        Font font = new Font("Verdana", Font.PLAIN, 18); шрифт
        deleteFigure.add(deleteFig);
        deleteFigure.add(b3);
        deleteFigure.add(b2);

        setVisible(true);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b3) {
                    figures.remove(activeFigure);
                    canvas.repaintGraph(figures);
                    deleteFigure.removeAll();
                    deleteFigure.revalidate();
                    deleteFigure.dispose();
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b2) {
                    deleteFigure.dispose();
                }

            }
        });
    }

    public void selectionWindow() {
        addFigure = new JFrame("Добавление фигуры");
        addFigure.setSize(350, 500);
        addFigure.setResizable(false);
        addFigure.setVisible(true);
        Container g = addFigure.getContentPane();
        JPanel addPanel = new JPanel();
        addPanel.setLayout(new FlowLayout());
        addFigure.add(addPanel);

//        Font font = new Font("Verdana", Font.PLAIN, 18); шрифт
        b1 = new JButton("Создать");
        b5 = new JButton("                      +                      ");
        this.l1 = new ArrayList<>();
        this.l2 = new ArrayList<>();
        this.l1.add(new JLabel("    Введите х:   "));
        this.l2.add(new JLabel("    Введите y:   "));
        this.xText = new ArrayList<>();
        this.yText = new ArrayList<>();
        this.xText.add(new JTextField(20));
        this.yText.add(new JTextField(20));
        addPanel.add(l1.get(0));
        addPanel.add(xText.get(0));
        addPanel.add(l2.get(0));
        addPanel.add(yText.get(0));
        addPanel.add(b5);
        addPanel.add(b1);

        g.add(addPanel);
        setVisible(true);

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b5) {

                    l1.add(new JLabel("    Введите х:   "));
                    addPanel.add(l1.get(l1.size() - 1));
                    l2.add(new JLabel("    Введите y:   "));
                    xText.add(new JTextField(20));
                    addPanel.add(xText.get(xText.size() - 1));
                    addPanel.add(l2.get(l2.size() - 1));
                    yText.add(new JTextField(20));
                    addPanel.add(yText.get(yText.size() - 1));
                    addPanel.revalidate();
                }
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    ArrayList<Point> points = new ArrayList<>();
                    for (int i = 0; i < xText.size(); i++) {
                        points.add(new Point(Double.valueOf(xText.get(i).getText()), Double.valueOf(yText.get(i).getText())));
                    }
                    FigureCreator figureCreator;
                    figureCreator = null;
                    switch (points.size()) {
                        case 2:
                            figureCreator = new CircleCreator();
                            break;

                        case 3:
                            figureCreator = new TriangleCreator();
                            break;

                        case 4:
                            figureCreator = new RectangleCreator();
                            break;
                         default:
                            figureCreator = new PolygonCreator();
                            break;
//                revalidate();
//                repaint();
//                JOptionPane.showMessageDialog(new Frame("ОПАСНО!"), "Некорректное кол-во точек.");
//                break;
                    }
                    if (figureCreator != null) {
                        Figure figure = figureCreator.create(points);
                        figures.add(figure);
                        for (JTextField xText : xText) addPanel.remove(xText);
                        for (JTextField yText : yText) addPanel.remove(yText);
                        xText.clear();
                        yText.clear();
                        addPanel.removeAll();

                        canvas.repaintGraph(figures);
                        addPanel.revalidate();
                    }
//            else JOptionPane.showMessageDialog(null, "Нет фигуры из одной точки");
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
