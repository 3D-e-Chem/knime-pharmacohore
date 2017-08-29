package nl.esciencecenter.e3dchem.knime.pharmacophore.align;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentBoolean;
import org.knime.core.node.defaultnodesettings.DialogComponentColumnNameSelection;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;

import nl.esciencecenter.e3dchem.knime.pharmacophore.PharValue;

/**
 * <code>NodeDialog</code> for the "AlignmentTransform" Node.
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows creation of a simple dialog with standard
 * components. If you need a more complex dialog please derive directly from {@link org.knime.core.node.NodeDialogPane}.
 */
public class AlignDialog extends DefaultNodeSettingsPane {

    /**
     * New pane for configuring AlignmentTransform node dialog. This is just a suggestion to demonstrate possible default dialog
     * components.
     */
    @SuppressWarnings("unchecked")
    protected AlignDialog() {
        super();

        AlignConfig config = new AlignConfig();

        addDialogComponent(new DialogComponentColumnNameSelection(config.getQueryColumn(), "Query Pharmacophore column (table 1)",
                AlignModel.QUERY_PORT, PharValue.class));

        addDialogComponent(new DialogComponentColumnNameSelection(config.getReferenceColumn(),
                "Reference Pharmacophore column (table 2)", AlignModel.REFERENCE_PORT, PharValue.class));

        createNewTab("Advanced");

        addDialogComponent(new DialogComponentNumber(config.getCutoff(),
                "Tolerance threshold for considering two distances to be equivalent", 0.1));

        addDialogComponent(new DialogComponentNumber(config.getCliqueBreak(), "Break when set number of cliques is found", 1));

        addDialogComponent(new DialogComponentNumber(config.getCliques2align(),
                "Number of cliques of each query pharmacophore to align", 1));

        addDialogComponent(new DialogComponentBoolean(config.getAllalignments(), "All alignments of cliques"));

        addDialogComponent(new DialogComponentBoolean(config.getIncludeReference(), "Include reference pharmacophore in output"));
    }
}
