package com.sharan.ui.myAccount.renderers;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class GenerateRenderer extends JButton implements TableCellRenderer {

    public GenerateRenderer() {
        setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 16));
        setOpaque(true);
        setForeground(Color.WHITE);
        setBackground(Color.RED);
        setHorizontalAlignment(CENTER);

        setBorder(BorderFactory.createEtchedBorder());
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }


}
