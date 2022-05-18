package NoSQLPackage;

import NoSQL_Schema.NoSQL_SchemaPackage;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EAnnotationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class NoSQLGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource input, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    final NoSQL_SchemaPackage MetaModel = NoSQL_SchemaPackage.eINSTANCE;
    String _name = MetaModel.getName();
    String _plus = (_name + ".odesign");
    fsa.generateFile(_plus, this.compile(MetaModel));
  }
  
  public CharSequence compile(final NoSQL_SchemaPackage mmPackage) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    final String viewpoint = this.getViewpoint(mmPackage);
    _builder.newLineIfNotEmpty();
    final String diagram = this.getDiagram(mmPackage);
    _builder.newLineIfNotEmpty();
    final String fileextension = this.getExtension(mmPackage).toLowerCase();
    _builder.newLineIfNotEmpty();
    _builder.append("<description:Group xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:description=\"http://www.eclipse.org/sirius/description/1.1.0\" xmlns:description_1=\"http://www.eclipse.org/sirius/diagram/description/1.1.0\" xmlns:properties=\"http://www.eclipse.org/sirius/properties/1.0.0\" xmlns:style=\"http://www.eclipse.org/sirius/diagram/description/style/1.1.0\" xmlns:tool=\"http://www.eclipse.org/sirius/diagram/description/tool/1.1.0\" xmlns:tool_1=\"http://www.eclipse.org/sirius/description/tool/1.1.0\" name=\"NoSQL_Schema\" version=\"12.0.0.2017041100\">");
    _builder.newLine();
    _builder.append("<ownedViewpoints name=\"");
    _builder.append(viewpoint);
    _builder.append("\" modelFileExtension=\"");
    _builder.append(fileextension);
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    final String mainclass = this.getMainClass(mmPackage);
    _builder.newLineIfNotEmpty();
    _builder.append("  \t    ");
    _builder.append("<ownedRepresentations xsi:type=\"description_1:DiagramDescription\" name=\"");
    _builder.append(diagram, "  \t    ");
    _builder.append("\" domainClass=\"");
    String _name = mmPackage.getName();
    _builder.append(_name, "  \t    ");
    _builder.append("::");
    _builder.append(mainclass, "  \t    ");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("  \t    ");
    _builder.append("<metamodel href=\"");
    String _nsURI = mmPackage.getNsURI();
    _builder.append(_nsURI, "  \t    ");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("  \t    ");
    _builder.append("<defaultLayer name=\"Default\">");
    _builder.newLine();
    _builder.append("  \t    ");
    final ArrayList<EObject> nodes = this.getNodes(mmPackage);
    _builder.newLineIfNotEmpty();
    {
      for(final EObject n : nodes) {
        _builder.append("\t\t  \t    ");
        final EAnnotationImpl nodeAnnotation = this.getNodeAnnotation(n);
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t  \t    ");
        String border = nodeAnnotation.getDetails().get("bordercolor");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t  \t    ");
        String labelcolor = nodeAnnotation.getDetails().get("labelcolor");
        _builder.newLineIfNotEmpty();
        final EAnnotationImpl editNameAnnotations = this.getToolsAnnotation(mmPackage, "DirectEditLabel", nodeAnnotation.getDetails().get("name"), nodeAnnotation);
        _builder.newLineIfNotEmpty();
        final String label = nodeAnnotation.getDetails().get("label");
        _builder.newLineIfNotEmpty();
        final String icon = nodeAnnotation.getDetails().get("icon");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t  \t    \t");
        _builder.append("<nodeMappings name=\"");
        String _get = nodeAnnotation.getDetails().get("name");
        _builder.append(_get, "\t\t  \t    \t");
        _builder.append("\"");
        {
          if ((editNameAnnotations != null)) {
            _builder.append(" labelDirectEdit=\"");
            String _toolString = this.getToolString(editNameAnnotations, viewpoint, diagram);
            _builder.append(_toolString, "\t\t  \t    \t");
            _builder.append("\"");
          }
        }
        _builder.append(" semanticCandidatesExpression=\"");
        String _get_1 = nodeAnnotation.getDetails().get("expression");
        _builder.append(_get_1, "\t\t  \t    \t");
        _builder.append("\" domainClass=\"");
        String _name_1 = mmPackage.getName();
        _builder.append(_name_1, "\t\t  \t    \t");
        _builder.append("::");
        String _get_2 = nodeAnnotation.getDetails().get("domain");
        _builder.append(_get_2, "\t\t  \t    \t");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t  \t    \t\t");
        _builder.append("<style xsi:type=\"style:");
        String _get_3 = nodeAnnotation.getDetails().get("style");
        _builder.append(_get_3, "\t\t  \t    \t\t");
        _builder.append("\" labelSize=\"12\" ");
        {
          if ((label != null)) {
            _builder.append(" labelExpression=\"");
            _builder.append(label, "\t\t  \t    \t\t");
            _builder.append("\" ");
          }
        }
        _builder.append(" ");
        {
          if ((icon != null)) {
            _builder.append("showIcon=\"");
            String _get_4 = nodeAnnotation.getDetails().get("icon");
            _builder.append(_get_4, "\t\t  \t    \t\t");
            _builder.append("\" ");
          }
        }
        _builder.append(" labelPosition=\"node\" sizeComputationExpression=\"2\" resizeKind=\"NSEW\" ");
        String _nodeWidth = this.getNodeWidth(nodeAnnotation);
        _builder.append(_nodeWidth, "\t\t  \t    \t\t");
        _builder.append(" ");
        String _nodeHeight = this.getNodeHeight(nodeAnnotation);
        _builder.append(_nodeHeight, "\t\t  \t    \t\t");
        _builder.append(">");
        _builder.newLineIfNotEmpty();
        {
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(border);
          if (_isNullOrEmpty) {
            _builder.append("\t\t  \t    \t\t\t");
            _builder.append("<borderColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
            _builder.newLine();
          } else {
            _builder.append("\t\t  \t    \t\t\t");
            _builder.append("<borderColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
            _builder.append(border, "\t\t  \t    \t\t\t");
            _builder.append("\']\"/>");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(labelcolor);
          if (_isNullOrEmpty_1) {
            _builder.append("\t\t  \t    \t\t\t");
            _builder.append("<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
            _builder.newLine();
          } else {
            _builder.append("\t\t  \t    \t\t\t");
            _builder.append("<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
            _builder.append(labelcolor, "\t\t  \t    \t\t\t");
            _builder.append("\']\"/>");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t  \t    \t\t\t");
        String _nodeColorString = this.getNodeColorString(nodeAnnotation);
        _builder.append(_nodeColorString, "\t\t  \t    \t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t  \t    \t\t");
        _builder.append("</style>");
        _builder.newLine();
        _builder.append("\t\t  \t    \t\t");
        String _alternateNode = this.getAlternateNode(mmPackage, nodeAnnotation);
        _builder.append(_alternateNode, "\t\t  \t    \t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t  \t    \t");
        _builder.append("</nodeMappings>");
        _builder.newLine();
      }
    }
    _builder.append("  \t    ");
    final ArrayList<EObject> edges = this.getEdges(mmPackage);
    _builder.newLineIfNotEmpty();
    {
      for(final EObject e : edges) {
        _builder.append("  \t    ");
        final EAnnotationImpl edgeAnnotations = this.getEdgeAnnotation(e);
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        final EAnnotationImpl deleteAnnotations = this.getToolsAnnotation(mmPackage, "DeleteElementDescription", edgeAnnotations.getDetails().get("name"), edgeAnnotations);
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        final EAnnotationImpl reconnectAnnotation = this.getToolsAnnotation(mmPackage, "ReconnectEdgeDescription", edgeAnnotations.getDetails().get("name"), edgeAnnotations);
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        String color = edgeAnnotations.getDetails().get("color");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        String label_1 = edgeAnnotations.getDetails().get("label");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        String labelcolor_1 = edgeAnnotations.getDetails().get("labelcolor");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        final String targetStyle = edgeAnnotations.getDetails().get("targetStyle");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        final String sourceStyle = edgeAnnotations.getDetails().get("sourceStyle");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        final String icon_1 = edgeAnnotations.getDetails().get("icon");
        _builder.newLineIfNotEmpty();
        {
          String _get_5 = edgeAnnotations.getDetails().get("type");
          boolean _equals = Objects.equal(_get_5, "element");
          if (_equals) {
            _builder.append("  \t    ");
            _builder.append("<edgeMappings name=\"");
            String _get_6 = edgeAnnotations.getDetails().get("name");
            _builder.append(_get_6, "  \t    ");
            _builder.append("\" ");
            {
              if ((deleteAnnotations != null)) {
                _builder.append(" deletionDescription=\"");
                String _toolString_1 = this.getToolString(deleteAnnotations, viewpoint, diagram);
                _builder.append(_toolString_1, "  \t    ");
                _builder.append("\" ");
              }
            }
            _builder.append(" ");
            {
              if ((reconnectAnnotation != null)) {
                _builder.append(" ");
                final ArrayList<EAnnotationImpl> tools = this.getReconnectionTools(mmPackage, "ReconnectEdgeDescription", edgeAnnotations.getDetails().get("name"));
                _builder.append(" reconnections=\"");
                {
                  for(final EAnnotationImpl t : tools) {
                    String _toolString_2 = this.getToolString(t, viewpoint, diagram);
                    _builder.append(_toolString_2, "  \t    ");
                  }
                }
                _builder.append("\" ");
              }
            }
            _builder.append(" semanticCandidatesExpression=\"");
            String _get_7 = edgeAnnotations.getDetails().get("expression");
            _builder.append(_get_7, "  \t    ");
            _builder.append("\" sourceMapping=\"");
            String _mappingString = this.getMappingString(mmPackage, edgeAnnotations, "source");
            _builder.append(_mappingString, "  \t    ");
            _builder.append("\" targetMapping=\"");
            String _mappingString_1 = this.getMappingString(mmPackage, edgeAnnotations, "target");
            _builder.append(_mappingString_1, "  \t    ");
            _builder.append("\" targetFinderExpression=\"");
            String _get_8 = edgeAnnotations.getDetails().get("targetFinderExpression");
            _builder.append(_get_8, "  \t    ");
            _builder.append("\" sourceFinderExpression=\"");
            String _get_9 = edgeAnnotations.getDetails().get("sourceFinderExpression");
            _builder.append(_get_9, "  \t    ");
            _builder.append("\" domainClass=\"");
            String _name_2 = mmPackage.getName();
            _builder.append(_name_2, "  \t    ");
            _builder.append("::");
            String _get_10 = edgeAnnotations.getDetails().get("domain");
            _builder.append(_get_10, "  \t    ");
            _builder.append("\" useDomainElement=\"true\">");
            _builder.newLineIfNotEmpty();
            _builder.append("  \t    ");
            _builder.append("<style ");
            {
              if ((targetStyle != null)) {
                _builder.append("targetArrow=\"");
                String _get_11 = edgeAnnotations.getDetails().get("targetStyle");
                _builder.append(_get_11, "  \t    ");
                _builder.append("\" ");
              }
            }
            _builder.append(" ");
            {
              if ((sourceStyle != null)) {
                _builder.append("sourceArrow=\"");
                String _get_12 = edgeAnnotations.getDetails().get("sourceStyle");
                _builder.append(_get_12, "  \t    ");
                _builder.append("\" ");
              }
            }
            _builder.append(" sizeComputationExpression=\"2\">");
            _builder.newLineIfNotEmpty();
            {
              boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(color);
              if (_isNullOrEmpty_2) {
                _builder.append("  \t    ");
                _builder.append("\t\t");
                _builder.append("<strokeColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
                _builder.newLine();
              } else {
                _builder.append("  \t    ");
                _builder.append("\t\t");
                _builder.append("<strokeColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
                _builder.append(color, "  \t    \t\t");
                _builder.append("\']\"/>");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("  \t    ");
            _builder.append("<centerLabelStyleDescription labelSize=\"12\" ");
            {
              if ((icon_1 != null)) {
                _builder.append("showIcon=\"");
                String _get_13 = edgeAnnotations.getDetails().get("icon");
                _builder.append(_get_13, "  \t    ");
                _builder.append("\" ");
              }
            }
            _builder.append(" ");
            {
              if ((label_1 != null)) {
                _builder.append(" labelExpression=\"");
                String _get_14 = edgeAnnotations.getDetails().get("label");
                _builder.append(_get_14, "  \t    ");
                _builder.append(" ");
              }
            }
            _builder.append("\">");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t  \t    \t\t");
            {
              boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(labelcolor_1);
              if (_isNullOrEmpty_3) {
                _builder.append(" \t\t\t<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t\t\t  \t    \t");
              } else {
                _builder.append("\t\t\t<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
                _builder.append(labelcolor_1, "\t\t\t\t  \t    \t\t");
                _builder.append("\']\"/>");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("  \t    ");
            _builder.append("</centerLabelStyleDescription>");
            _builder.newLine();
            _builder.append("  \t    ");
            _builder.append("</style>");
            _builder.newLine();
          } else {
            _builder.append("  \t    ");
            _builder.append("<edgeMappings name=\"");
            String _get_15 = edgeAnnotations.getDetails().get("name");
            _builder.append(_get_15, "  \t    ");
            _builder.append("\" ");
            {
              if ((deleteAnnotations != null)) {
                _builder.append(" deletionDescription=\"");
                String _toolString_3 = this.getToolString(deleteAnnotations, viewpoint, diagram);
                _builder.append(_toolString_3, "  \t    ");
                _builder.append("\" ");
              }
            }
            _builder.append(" ");
            {
              if ((reconnectAnnotation != null)) {
                _builder.append(" reconnections=\"");
                String _toolString_4 = this.getToolString(reconnectAnnotation, viewpoint, diagram);
                _builder.append(_toolString_4, "  \t    ");
                _builder.append("\" ");
              }
            }
            _builder.append(" sourceMapping=\"");
            String _mappingString_2 = this.getMappingString(mmPackage, edgeAnnotations, "source");
            _builder.append(_mappingString_2, "  \t    ");
            _builder.append("\" targetMapping=\"");
            String _mappingString_3 = this.getMappingString(mmPackage, edgeAnnotations, "target");
            _builder.append(_mappingString_3, "  \t    ");
            _builder.append("\" targetFinderExpression=\"");
            String _get_16 = edgeAnnotations.getDetails().get("targetFinderExpression");
            _builder.append(_get_16, "  \t    ");
            _builder.append("\">");
            _builder.newLineIfNotEmpty();
            _builder.append("  \t    ");
            _builder.append("<style ");
            {
              if ((targetStyle != null)) {
                _builder.append("targetArrow=\"");
                String _get_17 = edgeAnnotations.getDetails().get("targetStyle");
                _builder.append(_get_17, "  \t    ");
                _builder.append("\" ");
              }
            }
            _builder.append(" ");
            {
              if ((sourceStyle != null)) {
                _builder.append("sourceArrow=\"");
                String _get_18 = edgeAnnotations.getDetails().get("sourceStyle");
                _builder.append(_get_18, "  \t    ");
                _builder.append("\" ");
              }
            }
            _builder.append(" sizeComputationExpression=\"2\">");
            _builder.newLineIfNotEmpty();
            {
              boolean _isNullOrEmpty_4 = StringExtensions.isNullOrEmpty(color);
              if (_isNullOrEmpty_4) {
                _builder.append("  \t    ");
                _builder.append("\t\t");
                _builder.append("<strokeColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
                _builder.newLine();
              } else {
                _builder.append("  \t    ");
                _builder.append("\t\t");
                _builder.append("<strokeColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
                _builder.append(color, "  \t    \t\t");
                _builder.append("\']\"/>");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("  \t    ");
            _builder.append("\t\t\t");
            _builder.append("<centerLabelStyleDescription labelSize=\"12\" ");
            {
              if ((icon_1 != null)) {
                _builder.append("showIcon=\"");
                String _get_19 = edgeAnnotations.getDetails().get("icon");
                _builder.append(_get_19, "  \t    \t\t\t");
                _builder.append("\" ");
              }
            }
            _builder.append(" ");
            {
              if ((label_1 != null)) {
                _builder.append(" labelExpression=\"");
                String _get_20 = edgeAnnotations.getDetails().get("label");
                _builder.append(_get_20, "  \t    \t\t\t");
                _builder.append("\"");
              }
            }
            _builder.append(">");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t\t  \t    \t\t");
            {
              boolean _isNullOrEmpty_5 = StringExtensions.isNullOrEmpty(labelcolor_1);
              if (_isNullOrEmpty_5) {
                _builder.append(" \t\t\t<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t\t\t\t  \t    \t");
              } else {
                _builder.append("\t\t\t<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
                _builder.append(labelcolor_1, "\t\t\t\t  \t    \t\t");
                _builder.append("\']\"/>");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("  \t    ");
            _builder.append("            ");
            _builder.append("</centerLabelStyleDescription>");
            _builder.newLine();
            _builder.append("  \t    ");
            _builder.append("\t");
            _builder.append("</style>");
            _builder.newLine();
          }
        }
        _builder.append("\t\t\t         ");
        String _alternateEdge = this.getAlternateEdge(mmPackage, edgeAnnotations);
        _builder.append(_alternateEdge, "\t\t\t         ");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        _builder.append("</edgeMappings>");
        _builder.newLine();
      }
    }
    _builder.append("  \t    ");
    final ArrayList<EObject> containers = this.getContainers(mmPackage);
    _builder.append("\t\t  \t    ");
    _builder.newLineIfNotEmpty();
    {
      for(final EObject c : containers) {
        _builder.append("  \t    ");
        final EAnnotationImpl containerAnnotations = this.getContainerAnnotation(c);
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        final ArrayList<EAnnotationImpl> containerContents = this.getContainerContents(mmPackage, containerAnnotations.getDetails().get("name"));
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        final EAnnotationImpl editNameAnnotations_1 = this.getToolsAnnotation(mmPackage, "DirectEditLabel", containerAnnotations.getDetails().get("name"), containerAnnotations);
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        final String presentation = containerAnnotations.getDetails().get("presentation");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        final String label_2 = containerAnnotations.getDetails().get("label");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        _builder.append("<containerMappings name=\"");
        String _get_21 = containerAnnotations.getDetails().get("name");
        _builder.append(_get_21, "  \t    ");
        _builder.append("\"");
        {
          if ((editNameAnnotations_1 != null)) {
            _builder.append(" ");
            {
              if ((label_2 != null)) {
                _builder.append("labelExpression=\"");
                _builder.append(label_2, "  \t    ");
                _builder.append("\" ");
              }
            }
            _builder.append(" labelDirectEdit=\"");
            String _toolString_5 = this.getToolString(editNameAnnotations_1, viewpoint, diagram);
            _builder.append(_toolString_5, "  \t    ");
            _builder.append("\"");
          }
        }
        _builder.append(" semanticCandidatesExpression=\"");
        String _get_22 = containerAnnotations.getDetails().get("expression");
        _builder.append(_get_22, "  \t    ");
        _builder.append("\" domainClass=\"");
        String _name_3 = mmPackage.getName();
        _builder.append(_name_3, "  \t    ");
        _builder.append("::");
        String _get_23 = containerAnnotations.getDetails().get("domain");
        _builder.append(_get_23, "  \t    ");
        _builder.append("\"");
        {
          if ((presentation != null)) {
            _builder.append(" childrenPresentation=\"");
            _builder.append(presentation, "  \t    ");
            _builder.append("\"");
          }
        }
        _builder.append(">>");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        _builder.append("    ");
        _builder.append("<style xsi:type=\"style:FlatContainerStyleDescription\"  borderSizeComputationExpression=\"1\" labelSize=\"12\" showIcon=\"false\" roundedCorner=\"true\">");
        _builder.newLine();
        _builder.append("  \t    ");
        _builder.append("    \t");
        _builder.append("<borderColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
        _builder.newLine();
        _builder.append("  \t    ");
        _builder.append("        ");
        _builder.append("<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
        _builder.newLine();
        _builder.append("  \t    ");
        _builder.append("        ");
        _builder.append("<backgroundColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
        String _get_24 = containerAnnotations.getDetails().get("foreground");
        _builder.append(_get_24, "  \t            ");
        _builder.append("\']\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        _builder.append("        ");
        _builder.append("<foregroundColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
        String _get_25 = containerAnnotations.getDetails().get("background");
        _builder.append(_get_25, "  \t            ");
        _builder.append("\']\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        _builder.append("\t");
        _builder.append("</style>");
        _builder.newLine();
        {
          for(final EAnnotationImpl contents : containerContents) {
            _builder.append("  \t    ");
            _builder.append("\t");
            CharSequence _contentsString = this.getContentsString(contents, mmPackage);
            _builder.append(_contentsString, "  \t    \t");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  \t    ");
        _builder.append("</containerMappings>");
        _builder.newLine();
      }
    }
    _builder.append("  \t    ");
    CharSequence _decorations = this.getDecorations(mmPackage);
    _builder.append(_decorations, "  \t    ");
    _builder.newLineIfNotEmpty();
    _builder.append("  \t    ");
    _builder.append("<toolSections name=\"Tools\">");
    _builder.newLine();
    _builder.append("  \t    ");
    final ArrayList<EObject> allNodes = this.getAllNodes(mmPackage);
    _builder.newLineIfNotEmpty();
    _builder.append("  \t   \t");
    final ArrayList<EAnnotationImpl> nodeTools = CollectionLiterals.<EAnnotationImpl>newArrayList();
    _builder.newLineIfNotEmpty();
    {
      for(final EObject n_1 : allNodes) {
        _builder.append("  \t    ");
        EAnnotationImpl nodeAnnotation_1 = this.getNodeAnnotation(n_1);
        _builder.newLineIfNotEmpty();
        {
          if ((nodeAnnotation_1 == null)) {
            _builder.append("  \t    ");
            _builder.append(nodeAnnotation_1 = this.getBorderedNodeAnnotation(n_1), "  \t    ");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("  \t    ");
        final EAnnotationImpl toolAnnotation = this.getToolsAnnotation(mmPackage, "NodeCreationDescription", nodeAnnotation_1.getDetails().get("name"), nodeAnnotation_1);
        _builder.newLineIfNotEmpty();
        {
          if ((toolAnnotation != null)) {
            {
              boolean _contains = nodeTools.contains(toolAnnotation);
              boolean _not = (!_contains);
              if (_not) {
                _builder.append("  \t    ");
                boolean _add = nodeTools.add(toolAnnotation);
                _builder.append(_add, "  \t    ");
                _builder.newLineIfNotEmpty();
                _builder.append("  \t    ");
                final String nameAnnotation = toolAnnotation.getDetails().get("nodename");
                _builder.newLineIfNotEmpty();
                _builder.append("  \t    ");
                final String label_3 = toolAnnotation.getDetails().get("label");
                _builder.newLineIfNotEmpty();
                _builder.append("  \t    ");
                final String changeFeature = toolAnnotation.getDetails().get("changeFeature");
                _builder.newLineIfNotEmpty();
                _builder.append("  \t    ");
                final String additionalFeature = toolAnnotation.getDetails().get("additionalFeature");
                _builder.newLineIfNotEmpty();
                _builder.append("  \t    ");
                _builder.append("<ownedTools xsi:type=\"tool:");
                String _get_26 = toolAnnotation.getDetails().get("type");
                _builder.append(_get_26, "  \t    ");
                _builder.append("\" name=\"");
                String _get_27 = toolAnnotation.getDetails().get("name");
                _builder.append(_get_27, "  \t    ");
                _builder.append("\" ");
                {
                  if ((label_3 != null)) {
                    _builder.append(" label=\"");
                    _builder.append(label_3, "  \t    ");
                    _builder.append("\" ");
                  }
                }
                _builder.append(" nodeMappings=\"");
                String _mappingString_4 = this.getMappingString(mmPackage, toolAnnotation, "mappings");
                _builder.append(_mappingString_4, "  \t    ");
                _builder.append("\">");
                _builder.newLineIfNotEmpty();
                _builder.append("  \t    ");
                _builder.append("\t");
                _builder.append("<variable name=\"container\"/>");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append("\t");
                _builder.append("<viewVariable name=\"containerView\"/>");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append("\t\t");
                _builder.append("<initialOperation>");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append("\t\t\t");
                _builder.append("<firstModelOperations xsi:type=\"tool_1:ChangeContext\" browseExpression=\"var:container\">");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append("\t\t\t\t");
                _builder.append("<subModelOperations xsi:type=\"tool_1:CreateInstance\" typeName=\"");
                String _name_4 = mmPackage.getName();
                _builder.append(_name_4, "  \t    \t\t\t\t");
                _builder.append("::");
                String _get_28 = nodeAnnotation_1.getDetails().get("domain");
                _builder.append(_get_28, "  \t    \t\t\t\t");
                _builder.append("\" referenceName=\"");
                String _get_29 = toolAnnotation.getDetails().get("reference");
                _builder.append(_get_29, "  \t    \t\t\t\t");
                _builder.append("\">");
                _builder.newLineIfNotEmpty();
                _builder.append("  \t    ");
                _builder.append("\t\t\t\t\t");
                {
                  if ((nameAnnotation != null)) {
                    _builder.append("<subModelOperations xsi:type=\"tool_1:SetValue\" featureName=\"name\" valueExpression=\"");
                    String _get_30 = toolAnnotation.getDetails().get("nodename");
                    _builder.append(_get_30, "  \t    \t\t\t\t\t");
                    _builder.append("\"/>");
                  }
                }
                _builder.newLineIfNotEmpty();
                {
                  if ((changeFeature != null)) {
                    _builder.append("  \t    ");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("<subModelOperations xsi:type=\"tool_1:SetValue\" featureName=\"");
                    _builder.append(changeFeature, "  \t    \t\t\t\t\t");
                    _builder.append("\" valueExpression=\"");
                    String _get_31 = toolAnnotation.getDetails().get("changeValue");
                    _builder.append(_get_31, "  \t    \t\t\t\t\t");
                    _builder.append("\"/>");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((additionalFeature != null)) {
                    _builder.append("  \t    ");
                    _builder.append("\t\t\t\t\t");
                    _builder.append("<subModelOperations xsi:type=\"tool_1:CreateInstance\" typeName=\"");
                    String _name_5 = mmPackage.getName();
                    _builder.append(_name_5, "  \t    \t\t\t\t\t");
                    _builder.append("::");
                    String _get_32 = toolAnnotation.getDetails().get("additionalInstance");
                    _builder.append(_get_32, "  \t    \t\t\t\t\t");
                    _builder.append("\" referenceName=\"");
                    _builder.append(additionalFeature, "  \t    \t\t\t\t\t");
                    _builder.append("\"/>");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("  \t    ");
                _builder.append("\t\t\t\t");
                _builder.append("</subModelOperations>");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append("\t\t\t");
                _builder.append("</firstModelOperations>");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append("\t\t");
                _builder.append("</initialOperation>");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append("</ownedTools>");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      for(final EObject e_1 : edges) {
        final EAnnotationImpl edgeAnnotation = this.getEdgeAnnotation(e_1);
        _builder.newLineIfNotEmpty();
        final EAnnotationImpl toolAnnotation_1 = this.getToolsAnnotation(mmPackage, "EdgeCreationDescription", edgeAnnotation.getDetails().get("name"), edgeAnnotation);
        _builder.newLineIfNotEmpty();
        {
          if ((toolAnnotation_1 != null)) {
            final String changeFeature_1 = toolAnnotation_1.getDetails().get("changeFeature");
            _builder.newLineIfNotEmpty();
            final String additionalFeature_1 = toolAnnotation_1.getDetails().get("additionalFeature");
            _builder.newLineIfNotEmpty();
            {
              String _get_33 = edgeAnnotation.getDetails().get("type");
              boolean _equals_1 = Objects.equal(_get_33, "relation");
              if (_equals_1) {
                _builder.append("<ownedTools xsi:type=\"tool:");
                String _get_34 = toolAnnotation_1.getDetails().get("type");
                _builder.append(_get_34);
                _builder.append("\" name=\"");
                String _get_35 = toolAnnotation_1.getDetails().get("name");
                _builder.append(_get_35);
                _builder.append("\" edgeMappings=\"//@ownedViewpoints[name=\'");
                _builder.append(viewpoint);
                _builder.append("\']/@ownedRepresentations[name=\'");
                _builder.append(diagram);
                _builder.append("\']/@defaultLayer/@edgeMappings[name=\'");
                String _get_36 = toolAnnotation_1.getDetails().get("mappings");
                _builder.append(_get_36);
                _builder.append("\']\">");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("<sourceVariable name=\"source\"/>");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("<targetVariable name=\"target\"/>");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("<sourceViewVariable name=\"sourceView\"/>");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("<targetViewVariable name=\"targetView\"/>");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("<initialOperation>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("<firstModelOperations xsi:type=\"tool_1:ChangeContext\" browseExpression=\"var:source\">");
                _builder.newLine();
                _builder.append("\t\t\t");
                _builder.append("<subModelOperations xsi:type=\"tool_1:SetValue\" featureName=\"");
                String _get_37 = toolAnnotation_1.getDetails().get("feature");
                _builder.append(_get_37, "\t\t\t");
                _builder.append("\" valueExpression=\"var:target\"/>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("</firstModelOperations>");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("</initialOperation>");
                _builder.newLine();
                _builder.append("</ownedTools>");
                _builder.newLine();
              } else {
                _builder.append("<ownedTools xsi:type=\"tool:");
                String _get_38 = toolAnnotation_1.getDetails().get("type");
                _builder.append(_get_38);
                _builder.append("\" name=\"");
                String _get_39 = toolAnnotation_1.getDetails().get("name");
                _builder.append(_get_39);
                _builder.append("\" edgeMappings=\"//@ownedViewpoints[name=\'");
                _builder.append(viewpoint);
                _builder.append("\']/@ownedRepresentations[name=\'");
                _builder.append(diagram);
                _builder.append("\']/@defaultLayer/@edgeMappings[name=\'");
                String _get_40 = toolAnnotation_1.getDetails().get("mappings");
                _builder.append(_get_40);
                _builder.append("\']\">");
                _builder.newLineIfNotEmpty();
                _builder.append("  ");
                _builder.append("<sourceVariable name=\"source\"/>");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("<targetVariable name=\"target\"/>");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("<sourceViewVariable name=\"sourceView\"/>");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("<targetViewVariable name=\"targetView\"/>");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("<initialOperation>");
                _builder.newLine();
                _builder.append("  ");
                final String container = toolAnnotation_1.getDetails().get("containerexpression");
                _builder.newLineIfNotEmpty();
                _builder.append("  ");
                {
                  if ((container != null)) {
                    _builder.append("<firstModelOperations xsi:type=\"tool_1:ChangeContext\" browseExpression=\"");
                    String _get_41 = toolAnnotation_1.getDetails().get("containerexpression");
                    _builder.append(_get_41, "  ");
                    _builder.append("\">");
                    _builder.newLineIfNotEmpty();
                    _builder.append("  ");
                    _builder.append("<subModelOperations xsi:type=\"tool_1:CreateInstance\" typeName=\"");
                    String _name_6 = mmPackage.getName();
                    _builder.append(_name_6, "  ");
                    _builder.append("::");
                    String _get_42 = edgeAnnotation.getDetails().get("domain");
                    _builder.append(_get_42, "  ");
                    _builder.append("\" referenceName=\"");
                    String _get_43 = toolAnnotation_1.getDetails().get("reference");
                    _builder.append(_get_43, "  ");
                    _builder.append("\">");
                    _builder.newLineIfNotEmpty();
                  } else {
                    _builder.append("  ");
                    _builder.append("<firstModelOperations xsi:type=\"tool_1:CreateInstance\" typeName=\"");
                    String _name_7 = mmPackage.getName();
                    _builder.append(_name_7, "  ");
                    _builder.append("::");
                    String _get_44 = edgeAnnotation.getDetails().get("domain");
                    _builder.append(_get_44, "  ");
                    _builder.append("\" referenceName=\"");
                    String _get_45 = toolAnnotation_1.getDetails().get("reference");
                    _builder.append(_get_45, "  ");
                    _builder.append("\">");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("      ");
                _builder.append("<subModelOperations xsi:type=\"tool_1:SetValue\" featureName=\"");
                String _get_46 = toolAnnotation_1.getDetails().get("source");
                _builder.append(_get_46, "      ");
                _builder.append("\" valueExpression=\"var:source\"/>");
                _builder.newLineIfNotEmpty();
                _builder.append("      ");
                _builder.append("<subModelOperations xsi:type=\"tool_1:SetValue\" featureName=\"");
                String _get_47 = toolAnnotation_1.getDetails().get("target");
                _builder.append(_get_47, "      ");
                _builder.append("\" valueExpression=\"var:target\"/>");
                _builder.newLineIfNotEmpty();
                {
                  if ((changeFeature_1 != null)) {
                    _builder.append("      ");
                    _builder.append("<subModelOperations xsi:type=\"tool_1:SetValue\" featureName=\"");
                    _builder.append(changeFeature_1, "      ");
                    _builder.append("\" valueExpression=\"");
                    String _get_48 = toolAnnotation_1.getDetails().get("changeValue");
                    _builder.append(_get_48, "      ");
                    _builder.append("\"/>");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((changeFeature_1 != null)) {
                    _builder.append("      ");
                    _builder.append("<subModelOperations xsi:type=\"tool_1:CreateInstance\" typeName=\"");
                    String _name_8 = mmPackage.getName();
                    _builder.append(_name_8, "      ");
                    _builder.append("::");
                    String _get_49 = toolAnnotation_1.getDetails().get("additionalInstance");
                    _builder.append(_get_49, "      ");
                    _builder.append("\" referenceName=\"");
                    _builder.append(additionalFeature_1, "      ");
                    _builder.append("\"/>");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("   \t");
                {
                  if ((container != null)) {
                    _builder.append("</subModelOperations>");
                  }
                }
                _builder.newLineIfNotEmpty();
                _builder.append("   ");
                _builder.append("</firstModelOperations>");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("</initialOperation>");
                _builder.newLine();
                _builder.append("</ownedTools>");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    {
      for(final EObject e_2 : edges) {
        _builder.append("                 ");
        final EAnnotationImpl edgeAnnotation_1 = this.getEdgeAnnotation(e_2);
        _builder.newLineIfNotEmpty();
        _builder.append("                 ");
        final EAnnotationImpl toolAnnotation_2 = this.getToolsAnnotation(mmPackage, "DeleteElementDescription", edgeAnnotation_1.getDetails().get("name"), edgeAnnotation_1);
        _builder.newLineIfNotEmpty();
        {
          if ((toolAnnotation_2 != null)) {
            _builder.append("                 ");
            _builder.append("<ownedTools xsi:type=\"tool:");
            String _get_50 = toolAnnotation_2.getDetails().get("type");
            _builder.append(_get_50, "                 ");
            _builder.append("\" name=\"");
            String _get_51 = toolAnnotation_2.getDetails().get("name");
            _builder.append(_get_51, "                 ");
            _builder.append("\">");
            _builder.newLineIfNotEmpty();
            _builder.append("                 ");
            _builder.append("<element name=\"element\"/>");
            _builder.newLine();
            _builder.append("                 ");
            _builder.append("    \t\t");
            _builder.append("<elementView name=\"elementView\"/>");
            _builder.newLine();
            _builder.append("                 ");
            _builder.append("            ");
            _builder.append("<containerView name=\"containerView\"/>");
            _builder.newLine();
            _builder.append("                 ");
            _builder.append("            ");
            _builder.append("<initialOperation>");
            _builder.newLine();
            _builder.append("                 ");
            _builder.append("            \t");
            _builder.append("<firstModelOperations xsi:type=\"tool_1:ChangeContext\" browseExpression=\"var:element\">");
            _builder.newLine();
            _builder.append("                 ");
            _builder.append("                \t");
            _builder.append("<subModelOperations xsi:type=\"tool_1:Unset\" featureName=\"");
            String _get_52 = toolAnnotation_2.getDetails().get("feature");
            _builder.append(_get_52, "                                 \t");
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
            _builder.append("                 ");
            _builder.append("                ");
            _builder.append("</firstModelOperations>");
            _builder.newLine();
            _builder.append("                 ");
            _builder.append("            ");
            _builder.append("</initialOperation>");
            _builder.newLine();
            _builder.append("                 ");
            _builder.append("</ownedTools>");
            _builder.newLine();
          }
        }
      }
    }
    {
      for(final EObject e_3 : edges) {
        _builder.append("                 ");
        final EAnnotationImpl edgeAnnotation_2 = this.getEdgeAnnotation(e_3);
        _builder.newLineIfNotEmpty();
        _builder.append("                 ");
        final EAnnotationImpl toolAnnotation_3 = this.getToolsAnnotation(mmPackage, "ReconnectEdgeDescription", edgeAnnotation_2.getDetails().get("name"), edgeAnnotation_2);
        _builder.newLineIfNotEmpty();
        {
          if ((toolAnnotation_3 != null)) {
            _builder.append("                 ");
            final ArrayList<EAnnotationImpl> tools_1 = this.getReconnectionTools(mmPackage, "ReconnectEdgeDescription", edgeAnnotation_2.getDetails().get("name"));
            _builder.newLineIfNotEmpty();
            {
              for(final EAnnotationImpl t_1 : tools_1) {
                _builder.append("                 ");
                final String unsetFeature = t_1.getDetails().get("unsetFeature");
                _builder.newLineIfNotEmpty();
                _builder.append("                 ");
                final String reconnectKind = t_1.getDetails().get("kind");
                _builder.newLineIfNotEmpty();
                _builder.append("                 ");
                _builder.append("<ownedTools xsi:type=\"tool:");
                String _get_53 = t_1.getDetails().get("type");
                _builder.append(_get_53, "                 ");
                _builder.append("\" name=\"");
                String _get_54 = t_1.getDetails().get("name");
                _builder.append(_get_54, "                 ");
                _builder.append("\" ");
                {
                  if (((reconnectKind != null) && Objects.equal(reconnectKind, "source"))) {
                    _builder.append(" reconnectionKind=\"RECONNECT_SOURCE\"");
                  }
                }
                _builder.append(">");
                _builder.newLineIfNotEmpty();
                _builder.append("                 ");
                _builder.append("<source name=\"source\"/>");
                _builder.newLine();
                _builder.append("                 ");
                _builder.append("<target name=\"target\"/>");
                _builder.newLine();
                _builder.append("                 ");
                _builder.append("<sourceView name=\"sourceView\"/>");
                _builder.newLine();
                _builder.append("                 ");
                _builder.append("<targetView name=\"targetView\"/>");
                _builder.newLine();
                _builder.append("                 ");
                _builder.append("<element name=\"element\"/>");
                _builder.newLine();
                _builder.append("                 ");
                _builder.append("   ");
                _builder.append("<initialOperation>");
                _builder.newLine();
                _builder.append("                 ");
                _builder.append("   ");
                _builder.append("<firstModelOperations xsi:type=\"tool_1:ChangeContext\" browseExpression=\"var:element\">");
                _builder.newLine();
                {
                  if ((unsetFeature != null)) {
                    _builder.append("                 ");
                    _builder.append("   \t\t");
                    _builder.append("<subModelOperations xsi:type=\"tool_1:Unset\" featureName=\"");
                    _builder.append(unsetFeature, "                    \t\t");
                    _builder.append("\" elementExpression=\"");
                    String _get_55 = t_1.getDetails().get("unsetReference");
                    _builder.append(_get_55, "                    \t\t");
                    _builder.append("\"/>");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("                 ");
                _builder.append("   \t\t");
                _builder.append("<subModelOperations xsi:type=\"tool_1:SetValue\" featureName=\"");
                String _get_56 = t_1.getDetails().get("feature");
                _builder.append(_get_56, "                    \t\t");
                _builder.append("\" valueExpression=\"var:target\"/>");
                _builder.newLineIfNotEmpty();
                _builder.append("                 ");
                _builder.append("   \t");
                _builder.append("</firstModelOperations>");
                _builder.newLine();
                _builder.append("                 ");
                _builder.append("    ");
                _builder.append("</initialOperation>");
                _builder.newLine();
                _builder.append("                 ");
                _builder.append("<edgeView name=\"edgeView\"/>");
                _builder.newLine();
                _builder.append("                 ");
                _builder.append("</ownedTools>");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("                ");
    final EAnnotationImpl directAnnoTool = this.getUniversalTool(mmPackage, "DirectEditLabel");
    _builder.newLineIfNotEmpty();
    {
      if ((directAnnoTool == null)) {
        {
          for(final EObject n_2 : nodes) {
            final EAnnotationImpl nodeAnnotation_2 = this.getNodeAnnotation(n_2);
            _builder.newLineIfNotEmpty();
            final EAnnotationImpl toolAnnotation_4 = this.getToolsAnnotation(mmPackage, "DirectEditLabel", nodeAnnotation_2.getDetails().get("name"), nodeAnnotation_2);
            _builder.newLineIfNotEmpty();
            {
              if ((toolAnnotation_4 != null)) {
                _builder.append("<ownedTools xsi:type=\"tool:");
                String _get_57 = toolAnnotation_4.getDetails().get("type");
                _builder.append(_get_57);
                _builder.append("\" name=\"");
                String _get_58 = toolAnnotation_4.getDetails().get("name");
                _builder.append(_get_58);
                _builder.append("\">");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("<mask mask=\"{0}\"/>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("<initialOperation>");
                _builder.newLine();
                _builder.append("\t\t");
                _builder.append("<firstModelOperations xsi:type=\"tool_1:SetValue\" featureName=\"");
                String _get_59 = toolAnnotation_4.getDetails().get("feature");
                _builder.append(_get_59, "\t\t");
                _builder.append("\" valueExpression=\"");
                String _get_60 = toolAnnotation_4.getDetails().get("value");
                _builder.append(_get_60, "\t\t");
                _builder.append("\"/>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("</initialOperation>");
                _builder.newLine();
                _builder.append("</ownedTools>");
                _builder.newLine();
              }
            }
          }
        }
      } else {
        _builder.append("<ownedTools xsi:type=\"tool:");
        String _get_61 = directAnnoTool.getDetails().get("type");
        _builder.append(_get_61);
        _builder.append("\" name=\"");
        String _get_62 = directAnnoTool.getDetails().get("name");
        _builder.append(_get_62);
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("<mask mask=\"{0}\"/>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("<initialOperation>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<firstModelOperations xsi:type=\"tool_1:SetValue\" featureName=\"");
        String _get_63 = directAnnoTool.getDetails().get("feature");
        _builder.append(_get_63, "\t\t");
        _builder.append("\" valueExpression=\"");
        String _get_64 = directAnnoTool.getDetails().get("value");
        _builder.append(_get_64, "\t\t");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</initialOperation>");
        _builder.newLine();
        _builder.append("</ownedTools>");
        _builder.newLine();
      }
    }
    _builder.append("  \t    ");
    final ArrayList<EObject> allContainers = this.getAllContainers(mmPackage);
    _builder.newLineIfNotEmpty();
    _builder.append("  \t    ");
    final ArrayList<EAnnotationImpl> containerTools = CollectionLiterals.<EAnnotationImpl>newArrayList();
    _builder.newLineIfNotEmpty();
    {
      for(final EObject c_1 : allContainers) {
        _builder.append("  \t    ");
        final EAnnotationImpl containerAnnotation = this.getContainerAnnotation(c_1);
        _builder.newLineIfNotEmpty();
        _builder.append("  \t    ");
        final EAnnotationImpl toolAnnotation_5 = this.getToolsAnnotation(mmPackage, "ContainerCreationDescription", containerAnnotation.getDetails().get("name"), containerAnnotation);
        _builder.newLineIfNotEmpty();
        {
          if ((toolAnnotation_5 != null)) {
            {
              boolean _contains_1 = containerTools.contains(toolAnnotation_5);
              boolean _not_1 = (!_contains_1);
              if (_not_1) {
                _builder.append("  \t    ");
                boolean _add_1 = containerTools.add(toolAnnotation_5);
                _builder.append(_add_1, "  \t    ");
                _builder.newLineIfNotEmpty();
                _builder.append("  \t    ");
                final String changeFeature_2 = toolAnnotation_5.getDetails().get("changeFeature");
                _builder.newLineIfNotEmpty();
                _builder.append("  \t    ");
                final String additionalFeature_2 = toolAnnotation_5.getDetails().get("additionalFeature");
                _builder.newLineIfNotEmpty();
                _builder.append("  \t    ");
                _builder.append("<ownedTools xsi:type=\"tool:");
                String _get_65 = toolAnnotation_5.getDetails().get("type");
                _builder.append(_get_65, "  \t    ");
                _builder.append("\" name=\"");
                String _get_66 = toolAnnotation_5.getDetails().get("name");
                _builder.append(_get_66, "  \t    ");
                _builder.append("\" containerMappings=\"");
                String _mappingString_5 = this.getMappingString(mmPackage, toolAnnotation_5, "mappings");
                _builder.append(_mappingString_5, "  \t    ");
                _builder.append("\">");
                _builder.newLineIfNotEmpty();
                _builder.append("  \t    ");
                _builder.append("    ");
                _builder.append("<variable name=\"container\"/>");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append("    ");
                _builder.append("<viewVariable name=\"containerView\"/>");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append("    ");
                _builder.append("<initialOperation>");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append("        ");
                _builder.append("<firstModelOperations xsi:type=\"tool_1:ChangeContext\" browseExpression=\"var:container\">");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append("        \t");
                _builder.append("<subModelOperations xsi:type=\"tool_1:CreateInstance\" typeName=\"");
                String _name_9 = mmPackage.getName();
                _builder.append(_name_9, "  \t            \t");
                _builder.append("::");
                String _get_67 = containerAnnotation.getDetails().get("domain");
                _builder.append(_get_67, "  \t            \t");
                _builder.append("\" referenceName=\"");
                String _get_68 = toolAnnotation_5.getDetails().get("reference");
                _builder.append(_get_68, "  \t            \t");
                _builder.append("\"/>");
                _builder.newLineIfNotEmpty();
                {
                  if ((changeFeature_2 != null)) {
                    _builder.append("  \t    ");
                    _builder.append("        \t\t");
                    _builder.append("<subModelOperations xsi:type=\"tool_1:SetValue\" featureName=\"");
                    _builder.append(changeFeature_2, "  \t            \t\t");
                    _builder.append("\" valueExpression=\"");
                    String _get_69 = toolAnnotation_5.getDetails().get("changeValue");
                    _builder.append(_get_69, "  \t            \t\t");
                    _builder.append("\"/>");
                    _builder.newLineIfNotEmpty();
                  }
                }
                {
                  if ((additionalFeature_2 != null)) {
                    _builder.append("  \t    ");
                    _builder.append("        \t\t");
                    _builder.append("<subModelOperations xsi:type=\"tool_1:CreateInstance\" typeName=\"");
                    String _name_10 = mmPackage.getName();
                    _builder.append(_name_10, "  \t            \t\t");
                    _builder.append("::");
                    String _get_70 = toolAnnotation_5.getDetails().get("additionalInstance");
                    _builder.append(_get_70, "  \t            \t\t");
                    _builder.append("\" referenceName=\"");
                    _builder.append(additionalFeature_2, "  \t            \t\t");
                    _builder.append("\"/>");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("  \t    ");
                _builder.append("    \t");
                _builder.append("</firstModelOperations>");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append(" \t");
                _builder.append("</initialOperation>");
                _builder.newLine();
                _builder.append("  \t    ");
                _builder.append(" ");
                _builder.append("</ownedTools>");
                _builder.newLine();
              }
            }
          }
        }
      }
    }
    _builder.append("  \t    ");
    final ArrayList<EAnnotationImpl> doubleClickTools = this.getUniversalToolGroup(mmPackage, "DoubleClickDescription");
    _builder.newLineIfNotEmpty();
    {
      for(final EAnnotationImpl t_2 : doubleClickTools) {
        _builder.append("  \t    ");
        CharSequence _doubleClickToolString = this.getDoubleClickToolString(mmPackage, t_2);
        _builder.append(_doubleClickToolString, "  \t    ");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("</toolSections>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</defaultLayer>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</ownedRepresentations>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<ownedJavaExtensions qualifiedClassName=\"");
    String _path = this.getPath(mmPackage);
    _builder.append(_path, "\t");
    _builder.append(".Services\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</ownedViewpoints>");
    _builder.newLine();
    _builder.append("</description:Group>");
    _builder.newLine();
    return _builder;
  }
  
  private String getMainClass(final NoSQL_SchemaPackage mmPackage) {
    final EList<EAnnotation> contents = mmPackage.getEAnnotations();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EAnnotation element = contents.get((i).intValue());
        final String key = "mainclass";
        boolean _containsKey = element.getDetails().containsKey(key);
        if (_containsKey) {
          final String value = element.getDetails().get(key);
          return value;
        }
      }
    }
    return null;
  }
  
  private String getPath(final NoSQL_SchemaPackage mmPackage) {
    final EList<EAnnotation> contents = mmPackage.getEAnnotations();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EAnnotation element = contents.get((i).intValue());
        final String key = "path";
        boolean _containsKey = element.getDetails().containsKey(key);
        if (_containsKey) {
          final String value = element.getDetails().get(key);
          return value;
        }
      }
    }
    return null;
  }
  
  private String getViewpoint(final NoSQL_SchemaPackage mmPackage) {
    final EList<EAnnotation> contents = mmPackage.getEAnnotations();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EAnnotation element = contents.get((i).intValue());
        final String key = "viewpoint";
        boolean _containsKey = element.getDetails().containsKey(key);
        if (_containsKey) {
          final String value = element.getDetails().get(key);
          return value;
        }
        return "viewpoint";
      }
    }
    return null;
  }
  
  private String getExtension(final NoSQL_SchemaPackage mmPackage) {
    final EList<EAnnotation> contents = mmPackage.getEAnnotations();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EAnnotation element = contents.get((i).intValue());
        final String key = "extension";
        boolean _containsKey = element.getDetails().containsKey(key);
        if (_containsKey) {
          final String value = element.getDetails().get(key);
          return value;
        }
        return mmPackage.getName();
      }
    }
    return null;
  }
  
  private String getNodeHeight(final EAnnotationImpl NodeAnnotation) {
    final String height = NodeAnnotation.getDetails().get("height");
    final String type = NodeAnnotation.getDetails().get("style");
    if ((height != null)) {
      boolean _equals = Objects.equal(type, "EllipseNodeDescription");
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("verticalDiameterComputationExpression=\"");
        _builder.append(height);
        _builder.append("\"");
        return _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("height=\"");
        _builder_1.append(height);
        _builder_1.append("\"");
        return _builder_1.toString();
      }
    }
    return "";
  }
  
  private String getNodeWidth(final EAnnotationImpl NodeAnnotation) {
    final String width = NodeAnnotation.getDetails().get("width");
    final String type = NodeAnnotation.getDetails().get("style");
    if ((width != null)) {
      boolean _equals = Objects.equal(type, "EllipseNodeDescription");
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("horizontalDiameterComputationExpression=\"");
        _builder.append(width);
        _builder.append("\"");
        return _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("width=\"");
        _builder_1.append(width);
        _builder_1.append("\"");
        return _builder_1.toString();
      }
    }
    return "";
  }
  
  private String getDiagram(final NoSQL_SchemaPackage mmPackage) {
    final EList<EAnnotation> contents = mmPackage.getEAnnotations();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EAnnotation element = contents.get((i).intValue());
        final String key = "diagram";
        boolean _containsKey = element.getDetails().containsKey(key);
        if (_containsKey) {
          final String value = element.getDetails().get(key);
          return value;
        }
        return "diagram";
      }
    }
    return null;
  }
  
  private ArrayList<EObject> getNodes(final NoSQL_SchemaPackage mmPackage) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    final ArrayList<EObject> nodes = CollectionLiterals.<EObject>newArrayList();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EObject element = contents.get((i).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            if ((Objects.equal(annotation.getSource(), "sirius.node") && (Objects.equal(annotation.getDetails().get("container"), "default") || (annotation.getDetails().get("container") == null)))) {
              nodes.add(element);
            }
          }
        }
      }
    }
    return nodes;
  }
  
  private ArrayList<EObject> getAllNodes(final NoSQL_SchemaPackage mmPackage) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    final ArrayList<EObject> nodes = CollectionLiterals.<EObject>newArrayList();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EObject element = contents.get((i).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            if ((Objects.equal(annotation.getSource(), "sirius.node") || Objects.equal(annotation.getSource(), "sirius.borderednode"))) {
              nodes.add(element);
            }
          }
        }
      }
    }
    return nodes;
  }
  
  private ArrayList<EObject> getAllContainers(final NoSQL_SchemaPackage mmPackage) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    final ArrayList<EObject> nodes = CollectionLiterals.<EObject>newArrayList();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EObject element = contents.get((i).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            String _source = annotation.getSource();
            boolean _equals = Objects.equal(_source, "sirius.container");
            if (_equals) {
              nodes.add(element);
            }
          }
        }
      }
    }
    return nodes;
  }
  
  private ArrayList<EObject> getContainers(final NoSQL_SchemaPackage mmPackage) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    final ArrayList<EObject> containers = CollectionLiterals.<EObject>newArrayList();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EObject element = contents.get((i).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            if ((Objects.equal(annotation.getSource(), "sirius.container") && Objects.equal(annotation.getDetails().get("container"), "default"))) {
              containers.add(element);
            }
          }
        }
      }
    }
    return containers;
  }
  
  private ArrayList<EAnnotationImpl> getContainerContents(final NoSQL_SchemaPackage mmPackage, final String name) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    final ArrayList<EAnnotationImpl> containerContents = CollectionLiterals.<EAnnotationImpl>newArrayList();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EObject element = contents.get((i).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            String _get = annotation.getDetails().get("container");
            boolean _tripleNotEquals = (_get != null);
            if (_tripleNotEquals) {
              final String[] arr = annotation.getDetails().get("container").split(", ");
              for (final String a : arr) {
                boolean _equals = Objects.equal(a, name);
                if (_equals) {
                  boolean _contains = containerContents.contains(annotation);
                  boolean _not = (!_contains);
                  if (_not) {
                    if ((Objects.equal(annotation.getSource(), "sirius.node") || Objects.equal(annotation.getSource(), "sirius.borderednode"))) {
                      containerContents.add(annotation);
                    } else {
                      if ((a == name)) {
                        containerContents.add(annotation);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return containerContents;
  }
  
  private CharSequence getContentsString(final EAnnotationImpl annotation, final NoSQL_SchemaPackage mmPackage) {
    String _source = annotation.getSource();
    boolean _equals = Objects.equal(_source, "sirius.borderednode");
    if (_equals) {
      return this.getBorderedNodeString(annotation, mmPackage);
    } else {
      String _source_1 = annotation.getSource();
      boolean _equals_1 = Objects.equal(_source_1, "sirius.node");
      if (_equals_1) {
        return this.getSubNodeString(annotation, mmPackage);
      } else {
        String _source_2 = annotation.getSource();
        boolean _equals_2 = Objects.equal(_source_2, "sirius.container");
        if (_equals_2) {
          return this.getSubContainerString(annotation, mmPackage);
        }
      }
    }
    return null;
  }
  
  private CharSequence getContainedContentsString(final EAnnotationImpl annotation, final NoSQL_SchemaPackage mmPackage) {
    String _source = annotation.getSource();
    boolean _equals = Objects.equal(_source, "sirius.borderednode");
    if (_equals) {
      return this.getBorderedNodeString(annotation, mmPackage);
    } else {
      String _source_1 = annotation.getSource();
      boolean _equals_1 = Objects.equal(_source_1, "sirius.node");
      if (_equals_1) {
        return this.getSubNodeString(annotation, mmPackage);
      }
    }
    return null;
  }
  
  private CharSequence getBorderedNodeString(final EAnnotationImpl objectAnnotation, final NoSQL_SchemaPackage mmPackage) {
    StringConcatenation _builder = new StringConcatenation();
    final EAnnotationImpl editNameAnnotations = this.getToolsAnnotation(mmPackage, "DirectEditLabel", objectAnnotation.getDetails().get("name"), objectAnnotation);
    _builder.newLineIfNotEmpty();
    final String color = objectAnnotation.getDetails().get("color");
    _builder.newLineIfNotEmpty();
    _builder.append("<borderedNodeMappings name=\"");
    String _get = objectAnnotation.getDetails().get("name");
    _builder.append(_get);
    _builder.append("\"");
    {
      if ((editNameAnnotations != null)) {
        _builder.append(" labelDirectEdit=\"");
        String _toolString = this.getToolString(editNameAnnotations, this.getViewpoint(mmPackage), this.getDiagram(mmPackage));
        _builder.append(_toolString);
        _builder.append("\"");
      }
    }
    _builder.append(" semanticCandidatesExpression=\"");
    String _get_1 = objectAnnotation.getDetails().get("expression");
    _builder.append(_get_1);
    _builder.append("\" domainClass=\"");
    String _name = mmPackage.getName();
    _builder.append(_name);
    _builder.append("::");
    String _get_2 = objectAnnotation.getDetails().get("domain");
    _builder.append(_get_2);
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("<style xsi:type=\"style:");
    String _get_3 = objectAnnotation.getDetails().get("style");
    _builder.append(_get_3, "    ");
    _builder.append("\" labelSize=\"12\" showIcon=\"");
    String _get_4 = objectAnnotation.getDetails().get("icon");
    _builder.append(_get_4, "    ");
    _builder.append("\" labelExpression=\"");
    String _get_5 = objectAnnotation.getDetails().get("label");
    _builder.append(_get_5, "    ");
    _builder.append("\" labelPosition=\"node\" resizeKind=\"NSEW\" ");
    String _nodeWidth = this.getNodeWidth(objectAnnotation);
    _builder.append(_nodeWidth, "    ");
    _builder.append(" ");
    String _nodeHeight = this.getNodeHeight(objectAnnotation);
    _builder.append(_nodeHeight, "    ");
    _builder.append(">");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("<borderColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
    _builder.newLine();
    _builder.append("    \t\t");
    String _nodeColorString = this.getNodeColorString(objectAnnotation);
    _builder.append(_nodeColorString, "    \t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</style>");
    _builder.newLine();
    _builder.append("</borderedNodeMappings>");
    _builder.newLine();
    return _builder;
  }
  
  private String getNodeColorString(final EAnnotationImpl NodeAnnotation) {
    String backgroundColor = NodeAnnotation.getDetails().get("color");
    final String style = NodeAnnotation.getDetails().get("style");
    if ((backgroundColor == null)) {
      backgroundColor = "black";
    }
    boolean _equals = Objects.equal(style, "DotDescription");
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<backgroundColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
      _builder.append(backgroundColor);
      _builder.append("\']\"/>");
      return _builder.toString();
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("<color xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
      _builder_1.append(backgroundColor);
      _builder_1.append("\']\"/>");
      return _builder_1.toString();
    }
  }
  
  private CharSequence getSubNodeString(final EAnnotationImpl objectAnnotation, final NoSQL_SchemaPackage mmPackage) {
    StringConcatenation _builder = new StringConcatenation();
    String color = objectAnnotation.getDetails().get("color");
    _builder.newLineIfNotEmpty();
    String border = objectAnnotation.getDetails().get("bordercolor");
    _builder.newLineIfNotEmpty();
    String label = objectAnnotation.getDetails().get("labelcolor");
    _builder.newLineIfNotEmpty();
    final EAnnotationImpl editNameAnnotations = this.getToolsAnnotation(mmPackage, "DirectEditLabel", objectAnnotation.getDetails().get("name"), objectAnnotation);
    _builder.newLineIfNotEmpty();
    _builder.append("<subNodeMappings name=\"");
    String _get = objectAnnotation.getDetails().get("name");
    _builder.append(_get);
    _builder.append("\"");
    {
      if ((editNameAnnotations != null)) {
        _builder.append(" labelDirectEdit=\"");
        String _toolString = this.getToolString(editNameAnnotations, this.getViewpoint(mmPackage), this.getDiagram(mmPackage));
        _builder.append(_toolString);
        _builder.append("\"");
      }
    }
    _builder.append(" semanticCandidatesExpression=\"");
    String _get_1 = objectAnnotation.getDetails().get("expression");
    _builder.append(_get_1);
    _builder.append("\" domainClass=\"");
    String _name = mmPackage.getName();
    _builder.append(_name);
    _builder.append("::");
    String _get_2 = objectAnnotation.getDetails().get("domain");
    _builder.append(_get_2);
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("<style xsi:type=\"style:");
    String _get_3 = objectAnnotation.getDetails().get("style");
    _builder.append(_get_3, "    ");
    _builder.append("\" labelSize=\"12\" showIcon=\"");
    String _get_4 = objectAnnotation.getDetails().get("icon");
    _builder.append(_get_4, "    ");
    _builder.append("\" labelExpression=\"");
    String _get_5 = objectAnnotation.getDetails().get("label");
    _builder.append(_get_5, "    ");
    _builder.append("\" sizeComputationExpression=\"2\" labelPosition=\"node\" resizeKind=\"NSEW\" ");
    String _nodeWidth = this.getNodeWidth(objectAnnotation);
    _builder.append(_nodeWidth, "    ");
    _builder.append(" ");
    String _nodeHeight = this.getNodeHeight(objectAnnotation);
    _builder.append(_nodeHeight, "    ");
    _builder.append(">");
    _builder.newLineIfNotEmpty();
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(border);
      if (_isNullOrEmpty) {
        _builder.append("\t");
        _builder.append("<borderColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("<borderColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
        _builder.append(border, "\t");
        _builder.append("\']\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(label);
      if (_isNullOrEmpty_1) {
        _builder.append("\t");
        _builder.append("<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
        _builder.newLine();
      } else {
        _builder.append("\t");
        _builder.append("<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
        _builder.append(label, "\t");
        _builder.append("\']\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    String _nodeColorString = this.getNodeColorString(objectAnnotation);
    _builder.append(_nodeColorString, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</style>");
    _builder.newLine();
    _builder.append("\t");
    String _alternateNode = this.getAlternateNode(mmPackage, objectAnnotation);
    _builder.append(_alternateNode, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</subNodeMappings>");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence getSubContainerString(final EAnnotationImpl objectAnnotation, final NoSQL_SchemaPackage mmPackage) {
    StringConcatenation _builder = new StringConcatenation();
    final String mapping = objectAnnotation.getDetails().get("mapping");
    _builder.newLineIfNotEmpty();
    final ArrayList<EAnnotationImpl> containerContents = this.getContainerContents(mmPackage, objectAnnotation.getDetails().get("name"));
    _builder.newLineIfNotEmpty();
    final ArrayList<EAnnotationImpl> reuseMappings = this.getContainerContents(mmPackage, mapping);
    _builder.newLineIfNotEmpty();
    final EAnnotationImpl editNameAnnotations = this.getToolsAnnotation(mmPackage, "DirectEditLabel", objectAnnotation.getDetails().get("name"), objectAnnotation);
    _builder.newLineIfNotEmpty();
    final String presentation = objectAnnotation.getDetails().get("presentation");
    _builder.newLineIfNotEmpty();
    final String label = objectAnnotation.getDetails().get("label");
    _builder.newLineIfNotEmpty();
    _builder.append("<subContainerMappings name=\"");
    String _get = objectAnnotation.getDetails().get("name");
    _builder.append(_get);
    _builder.append("\"");
    {
      if ((editNameAnnotations != null)) {
        _builder.append(" labelDirectEdit=\"");
        String _toolString = this.getToolString(editNameAnnotations, this.getViewpoint(mmPackage), this.getDiagram(mmPackage));
        _builder.append(_toolString);
        _builder.append("\"");
      }
    }
    _builder.append(" semanticCandidatesExpression=\"");
    String _get_1 = objectAnnotation.getDetails().get("expression");
    _builder.append(_get_1);
    _builder.append("\" domainClass=\"");
    String _name = mmPackage.getName();
    _builder.append(_name);
    _builder.append("::");
    String _get_2 = objectAnnotation.getDetails().get("domain");
    _builder.append(_get_2);
    _builder.append("\" ");
    {
      if ((mapping != null)) {
        _builder.append("reusedContainerMappings=\"//@ownedViewpoints[name=\'");
        String _viewpoint = this.getViewpoint(mmPackage);
        _builder.append(_viewpoint);
        _builder.append("\']/@ownedRepresentations[name=\'");
        String _diagram = this.getDiagram(mmPackage);
        _builder.append(_diagram);
        _builder.append("\']/@defaultLayer/@containerMappings[name=\'");
        _builder.append(mapping);
        _builder.append("\']\"");
      }
    }
    {
      if ((presentation != null)) {
        _builder.append(" childrenPresentation=\"");
        _builder.append(presentation);
        _builder.append("\"");
      }
    }
    _builder.append(">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<style xsi:type=\"style:FlatContainerStyleDescription\" borderSizeComputationExpression=\"1\" ");
    {
      if ((label != null)) {
        _builder.append("labelExpression=\"");
        _builder.append(label, "\t");
        _builder.append("\" ");
      }
    }
    _builder.append(" labelSize=\"12\" showIcon=\"false\" roundedCorner=\"true\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<borderColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("<backgroundColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
    String _get_3 = objectAnnotation.getDetails().get("foreground");
    _builder.append(_get_3, "\t  \t");
    _builder.append("\']\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t  \t");
    _builder.append("<foregroundColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
    String _get_4 = objectAnnotation.getDetails().get("background");
    _builder.append(_get_4, "\t  \t");
    _builder.append("\']\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</style>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final EAnnotationImpl c : containerContents) {
        _builder.append("\t");
        Object _contentsString = this.getContentsString(c, mmPackage);
        _builder.append(_contentsString, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      if ((mapping != null)) {
        {
          for(final EAnnotationImpl c_1 : reuseMappings) {
            _builder.append("\t");
            CharSequence _containedContentsString = this.getContainedContentsString(c_1, mmPackage);
            _builder.append(_containedContentsString, "\t");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("</subContainerMappings>");
    _builder.newLine();
    return _builder;
  }
  
  private EAnnotationImpl getNodeAnnotation(final EObject o) {
    final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(o.eContents(), EAnnotationImpl.class));
    int _size = annotations.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer k : _doubleDotLessThan) {
      {
        final EAnnotationImpl annotation = annotations.get((k).intValue());
        String _source = annotation.getSource();
        boolean _equals = Objects.equal(_source, "sirius.node");
        if (_equals) {
          return annotation;
        }
      }
    }
    return null;
  }
  
  private EAnnotationImpl getBorderedNodeAnnotation(final EObject o) {
    final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(o.eContents(), EAnnotationImpl.class));
    int _size = annotations.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer k : _doubleDotLessThan) {
      {
        final EAnnotationImpl annotation = annotations.get((k).intValue());
        String _source = annotation.getSource();
        boolean _equals = Objects.equal(_source, "sirius.borderednode");
        if (_equals) {
          return annotation;
        }
      }
    }
    return null;
  }
  
  private EAnnotationImpl getContainerAnnotation(final EObject o) {
    final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(o.eContents(), EAnnotationImpl.class));
    int _size = annotations.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer k : _doubleDotLessThan) {
      {
        final EAnnotationImpl annotation = annotations.get((k).intValue());
        String _source = annotation.getSource();
        boolean _equals = Objects.equal(_source, "sirius.container");
        if (_equals) {
          return annotation;
        }
      }
    }
    return null;
  }
  
  private EAnnotationImpl getEdgeAnnotation(final EObject o) {
    final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(o.eContents(), EAnnotationImpl.class));
    int _size = annotations.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer k : _doubleDotLessThan) {
      {
        final EAnnotationImpl annotation = annotations.get((k).intValue());
        String _source = annotation.getSource();
        boolean _equals = Objects.equal(_source, "sirius.edge");
        if (_equals) {
          return annotation;
        }
      }
    }
    return null;
  }
  
  private EAnnotationImpl getToolsAnnotation(final NoSQL_SchemaPackage mmPackage, final String tool, final String name, final EAnnotation objectAnnotation) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EObject element = contents.get((i).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            if ((((Objects.equal(annotation.getSource(), "sirius.tool") && Objects.equal(annotation.getDetails().get("type"), tool)) && (annotation.getDetails().get("belongsto") != null)) && Objects.equal(annotation.getDetails().get("belongsto"), name))) {
              return annotation;
            } else {
              if ((Objects.equal(annotation.getSource(), "sirius.tool") && Objects.equal(annotation.getDetails().get("type"), tool))) {
                final String mappings = annotation.getDetails().get("mappings");
                if ((mappings != null)) {
                  final String[] strArr = mappings.split(", ");
                  int _size_2 = ((List<String>)Conversions.doWrapArray(strArr)).size();
                  ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_2, true);
                  for (final Integer m : _doubleDotLessThan_2) {
                    {
                      final String[] pair = (strArr[(m).intValue()]).split(":");
                      String _get = strArr[(m).intValue()];
                      boolean _equals = Objects.equal(_get, name);
                      if (_equals) {
                        return annotation;
                      } else {
                        int _size_3 = ((List<String>)Conversions.doWrapArray(pair)).size();
                        boolean _greaterEqualsThan = (_size_3 >= 2);
                        if (_greaterEqualsThan) {
                          String _get_1 = pair[0];
                          boolean _equals_1 = Objects.equal(_get_1, name);
                          if (_equals_1) {
                            final String[] containerArr = objectAnnotation.getDetails().get("container").split(", ");
                            boolean _contains = ArrayExtensions.contains(containerArr, pair[1]);
                            if (_contains) {
                              return annotation;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  private CharSequence getDoubleClickToolString(final NoSQL_SchemaPackage mmPackage, final EAnnotationImpl objectAnnotation) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<ownedTools xsi:type=\"tool:DoubleClickDescription\" name=\"");
    String _get = objectAnnotation.getDetails().get("name");
    _builder.append(_get);
    _builder.append("\" mappings=\"");
    String _mappingString = this.getMappingString(mmPackage, objectAnnotation, "mappings");
    _builder.append(_mappingString);
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<element name=\"element\"/>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<elementView name=\"elementView\"/>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<initialOperation>");
    _builder.newLine();
    _builder.append("    \t");
    final String title = objectAnnotation.getDetails().get("title");
    _builder.newLineIfNotEmpty();
    _builder.append("    \t");
    _builder.append("<firstModelOperations xsi:type=\"properties:DialogModelOperation\" ");
    {
      if ((title != null)) {
        _builder.append("titleExpression=\"");
        String _get_1 = objectAnnotation.getDetails().get("title");
        _builder.append(_get_1, "    \t");
        _builder.append("\"");
      } else {
        _builder.append("titleExpression=\"Default\"");
      }
    }
    _builder.append(">");
    _builder.newLineIfNotEmpty();
    _builder.append("        \t");
    _builder.append("<buttons labelExpression=\"Cancel\" closeDialogOnClick=\"true\" rollbackChangesOnClose=\"true\">");
    _builder.newLine();
    _builder.append("    \t\t\t");
    _builder.append("<initialOperation/>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("</buttons>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<buttons labelExpression=\"OK\" default=\"true\" closeDialogOnClick=\"true\">");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("<initialOperation>");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("<firstModelOperations xsi:type=\"tool_1:CreateInstance\" typeName=\"");
    String _name = mmPackage.getName();
    _builder.append(_name, "                ");
    _builder.append("::");
    String _get_2 = objectAnnotation.getDetails().get("targetType");
    _builder.append(_get_2, "                ");
    _builder.append("\" referenceName=\"");
    String _get_3 = objectAnnotation.getDetails().get("reference");
    _builder.append(_get_3, "                ");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("                  ");
    _builder.append("<subModelOperations xsi:type=\"tool_1:ChangeContext\" browseExpression=\"");
    String _get_4 = objectAnnotation.getDetails().get("browse");
    _builder.append(_get_4, "                  ");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("                    ");
    _builder.append("<subModelOperations xsi:type=\"tool_1:SetValue\" featureName=\"");
    String _get_5 = objectAnnotation.getDetails().get("feature");
    _builder.append(_get_5, "                    ");
    _builder.append("\" valueExpression=\"var:text\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("                  ");
    _builder.append("</subModelOperations>");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("</firstModelOperations>");
    _builder.newLine();
    _builder.append("              ");
    _builder.append("</initialOperation>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("</buttons>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<page name=\"Default Page\" labelExpression=\"Page\" domainClass=\"");
    String _name_1 = mmPackage.getName();
    _builder.append(_name_1, "            ");
    _builder.append("::");
    String _get_6 = objectAnnotation.getDetails().get("sourceType");
    _builder.append(_get_6, "            ");
    _builder.append("\" semanticCandidateExpression=\"var:self\" groups=\"//@ownedViewpoints[name=\'");
    String _viewpoint = this.getViewpoint(mmPackage);
    _builder.append(_viewpoint, "            ");
    _builder.append("\']/@ownedRepresentations[name=\'");
    String _diagram = this.getDiagram(mmPackage);
    _builder.append(_diagram, "            ");
    _builder.append("\']/@defaultLayer/@toolSections.0/@ownedTools[name=\'");
    String _get_7 = objectAnnotation.getDetails().get("name");
    _builder.append(_get_7, "            ");
    _builder.append("\']/@initialOperation/@firstModelOperations/@groups.0\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("            ");
    _builder.append("<groups name=\"Default Group\" labelExpression=\"Group\" domainClass=\"");
    String _name_2 = mmPackage.getName();
    _builder.append(_name_2, "            ");
    _builder.append("::");
    String _get_8 = objectAnnotation.getDetails().get("sourceType");
    _builder.append(_get_8, "            ");
    _builder.append("\" semanticCandidateExpression=\"var:self\">");
    _builder.newLineIfNotEmpty();
    _builder.append("              \t");
    _builder.append("<controls xsi:type=\"properties:TextDescription\" name=\"TextBox\" labelExpression=\"");
    String _get_9 = objectAnnotation.getDetails().get("label");
    _builder.append(_get_9, "              \t");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("                \t");
    _builder.append("<initialOperation>");
    _builder.newLine();
    _builder.append("                  \t\t");
    _builder.append("<firstModelOperations xsi:type=\"tool_1:Let\" variableName=\"text\" valueExpression=\"var:newValue\"/>");
    _builder.newLine();
    _builder.append("                \t");
    _builder.append("</initialOperation>");
    _builder.newLine();
    _builder.append("            \t");
    _builder.append("</controls>");
    _builder.newLine();
    _builder.append("        \t");
    _builder.append("</groups>");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("</firstModelOperations>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</initialOperation>");
    _builder.newLine();
    _builder.append("</ownedTools>");
    _builder.newLine();
    return _builder;
  }
  
  private ArrayList<EAnnotationImpl> getReconnectionTools(final NoSQL_SchemaPackage mmPackage, final String tool, final String name) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    ArrayList<EAnnotationImpl> annotationArr = CollectionLiterals.<EAnnotationImpl>newArrayList();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EObject element = contents.get((i).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            if ((((Objects.equal(annotation.getSource(), "sirius.tool") && Objects.equal(annotation.getDetails().get("type"), tool)) && (annotation.getDetails().get("belongsto") != null)) && Objects.equal(annotation.getDetails().get("belongsto"), name))) {
              annotationArr.add(annotation);
            }
          }
        }
      }
    }
    return annotationArr;
  }
  
  private EAnnotationImpl getUniversalTool(final NoSQL_SchemaPackage mmPackage, final String tool) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EObject element = contents.get((i).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            if (((Objects.equal(annotation.getSource(), "sirius.tool") && Objects.equal(annotation.getDetails().get("type"), tool)) && (annotation.getDetails().get("mappings") != null))) {
              return annotation;
            }
          }
        }
      }
    }
    return null;
  }
  
  private ArrayList<EAnnotationImpl> getUniversalToolGroup(final NoSQL_SchemaPackage mmPackage, final String tool) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    ArrayList<EAnnotationImpl> arr = CollectionLiterals.<EAnnotationImpl>newArrayList();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EObject element = contents.get((i).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            if (((Objects.equal(annotation.getSource(), "sirius.tool") && Objects.equal(annotation.getDetails().get("type"), tool)) && (annotation.getDetails().get("mappings") != null))) {
              arr.add(annotation);
            }
          }
        }
      }
    }
    return arr;
  }
  
  private ArrayList<EObject> getEdges(final NoSQL_SchemaPackage mmPackage) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    final ArrayList<EObject> edges = CollectionLiterals.<EObject>newArrayList();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final EObject element = contents.get((i).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            String _source = annotation.getSource();
            boolean _equals = Objects.equal(_source, "sirius.edge");
            if (_equals) {
              edges.add(element);
            }
          }
        }
      }
    }
    return edges;
  }
  
  private String getMappingString(final NoSQL_SchemaPackage mmPackage, final EAnnotationImpl objectAnnotation, final String search) {
    String str = "";
    String sourceString = objectAnnotation.getDetails().get(search);
    if ((sourceString == null)) {
      boolean _equals = Objects.equal(search, "mappings");
      if (_equals) {
        sourceString = objectAnnotation.getDetails().get("belongsto");
      } else {
        sourceString = objectAnnotation.getDetails().get("mappings");
      }
      if ((sourceString == null)) {
        String _get = objectAnnotation.getDetails().get("name");
        String _plus = (_get + " ERROR: Missing both belongsto and mappings");
        InputOutput.<String>println(_plus);
      }
    }
    final String[] strArr = sourceString.split(", ");
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    final ArrayList<EAnnotationImpl> reusedContainers = this.getReusedContainers(mmPackage);
    int _size = ((List<String>)Conversions.doWrapArray(strArr)).size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final String[] keyValue = (strArr[(i).intValue()]).split(":");
        ArrayList<EAnnotationImpl> containers = CollectionLiterals.<EAnnotationImpl>newArrayList();
        int _size_1 = ((List<String>)Conversions.doWrapArray(keyValue)).size();
        boolean _greaterEqualsThan = (_size_1 >= 2);
        if (_greaterEqualsThan) {
          int _size_2 = reusedContainers.size();
          ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_2, true);
          for (final Integer c : _doubleDotLessThan_1) {
            {
              final String comparison = reusedContainers.get((c).intValue()).getDetails().get("mapping");
              String _get_1 = keyValue[1];
              boolean _equals_1 = Objects.equal(_get_1, comparison);
              if (_equals_1) {
                containers.add(reusedContainers.get((c).intValue()));
              }
            }
          }
        }
        int _size_3 = contents.size();
        ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, _size_3, true);
        for (final Integer c_1 : _doubleDotLessThan_2) {
          {
            final EObject element = contents.get((c_1).intValue());
            final EList<EObject> elementContents = element.eContents();
            final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
            int _size_4 = annotations.size();
            ExclusiveRange _doubleDotLessThan_3 = new ExclusiveRange(0, _size_4, true);
            for (final Integer k : _doubleDotLessThan_3) {
              {
                final EAnnotationImpl annotation = annotations.get((k).intValue());
                int _size_5 = ((List<String>)Conversions.doWrapArray(keyValue)).size();
                boolean _lessThan = (_size_5 < 2);
                if (_lessThan) {
                  if ((Objects.equal(annotation.getSource(), "sirius.node") && Objects.equal(keyValue[0], annotation.getDetails().get("name")))) {
                    String _viewpoint = this.getViewpoint(mmPackage);
                    String _plus_1 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint);
                    String _plus_2 = (_plus_1 + "\']/@ownedRepresentations[name=\'");
                    String _diagram = this.getDiagram(mmPackage);
                    String _plus_3 = (_plus_2 + _diagram);
                    String _plus_4 = (_plus_3 + "\']/@defaultLayer/@nodeMappings[name=\'");
                    String _get_1 = keyValue[0];
                    String _plus_5 = (_plus_4 + _get_1);
                    String _plus_6 = (_plus_5 + "\'] ");
                    str = _plus_6;
                  } else {
                    if ((Objects.equal(annotation.getSource(), "sirius.container") && Objects.equal(keyValue[0], annotation.getDetails().get("name")))) {
                      String _viewpoint_1 = this.getViewpoint(mmPackage);
                      String _plus_7 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_1);
                      String _plus_8 = (_plus_7 + "\']/@ownedRepresentations[name=\'");
                      String _diagram_1 = this.getDiagram(mmPackage);
                      String _plus_9 = (_plus_8 + _diagram_1);
                      String _plus_10 = (_plus_9 + "\']/@defaultLayer/@containerMappings[name=\'");
                      String _get_2 = keyValue[0];
                      String _plus_11 = (_plus_10 + _get_2);
                      String _plus_12 = (_plus_11 + "\'] ");
                      str = _plus_12;
                    } else {
                      if ((Objects.equal(annotation.getSource(), "sirius.edge") && Objects.equal(keyValue[0], annotation.getDetails().get("name")))) {
                        String _viewpoint_2 = this.getViewpoint(mmPackage);
                        String _plus_13 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_2);
                        String _plus_14 = (_plus_13 + "\']/@ownedRepresentations[name=\'");
                        String _diagram_2 = this.getDiagram(mmPackage);
                        String _plus_15 = (_plus_14 + _diagram_2);
                        String _plus_16 = (_plus_15 + "\']/@defaultLayer/@edgeMappings[name=\'");
                        String _get_3 = keyValue[0];
                        String _plus_17 = (_plus_16 + _get_3);
                        String _plus_18 = (_plus_17 + "\'] ");
                        str = _plus_18;
                      }
                    }
                  }
                } else {
                  String _get_4 = annotation.getDetails().get("container");
                  boolean _tripleNotEquals = (_get_4 != null);
                  if (_tripleNotEquals) {
                    final String[] annotationContainers = annotation.getDetails().get("container").split(", ");
                    int _size_6 = ((List<String>)Conversions.doWrapArray(annotationContainers)).size();
                    boolean _greaterThan = (_size_6 > 2);
                    if (_greaterThan) {
                      if ((Objects.equal(keyValue[0], annotation.getDetails().get("name")) && ArrayExtensions.contains(annotationContainers, keyValue[1]))) {
                        String _source = annotation.getSource();
                        boolean _equals_1 = Objects.equal(_source, "sirius.node");
                        if (_equals_1) {
                          String _viewpoint_3 = this.getViewpoint(mmPackage);
                          String _plus_19 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_3);
                          String _plus_20 = (_plus_19 + "\']/@ownedRepresentations[name=\'");
                          String _diagram_3 = this.getDiagram(mmPackage);
                          String _plus_21 = (_plus_20 + _diagram_3);
                          String _plus_22 = (_plus_21 + "\']");
                          Object _containerStringSearch = this.getContainerStringSearch(mmPackage, annotation, keyValue[1]);
                          String _plus_23 = (_plus_22 + _containerStringSearch);
                          String _plus_24 = (_plus_23 + "/@subNodeMappings[name=\'");
                          String _get_5 = keyValue[0];
                          String _plus_25 = (_plus_24 + _get_5);
                          String _plus_26 = (_plus_25 + "\'] ");
                          str = _plus_26;
                          for (final EAnnotationImpl r : containers) {
                            String _viewpoint_4 = this.getViewpoint(mmPackage);
                            String _plus_27 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_4);
                            String _plus_28 = (_plus_27 + "\']/@ownedRepresentations[name=\'");
                            String _diagram_4 = this.getDiagram(mmPackage);
                            String _plus_29 = (_plus_28 + _diagram_4);
                            String _plus_30 = (_plus_29 + "\']");
                            Object _containerStringSearch_1 = this.getContainerStringSearch(mmPackage, annotation, keyValue[1]);
                            String _plus_31 = (_plus_30 + _containerStringSearch_1);
                            String _plus_32 = (_plus_31 + "/@subContainerMappings[name=\'");
                            String _get_6 = r.getDetails().get("name");
                            String _plus_33 = (_plus_32 + _get_6);
                            String _plus_34 = (_plus_33 + "\']");
                            String _plus_35 = (_plus_34 + "/@subNodeMappings[name=\'");
                            String _get_7 = keyValue[0];
                            String _plus_36 = (_plus_35 + _get_7);
                            String _plus_37 = (_plus_36 + "\'] ");
                            str = _plus_37;
                          }
                        } else {
                          String _source_1 = annotation.getSource();
                          boolean _equals_2 = Objects.equal(_source_1, "sirius.borderednode");
                          if (_equals_2) {
                            String _viewpoint_5 = this.getViewpoint(mmPackage);
                            String _plus_38 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_5);
                            String _plus_39 = (_plus_38 + "\']/@ownedRepresentations[name=\'");
                            String _diagram_5 = this.getDiagram(mmPackage);
                            String _plus_40 = (_plus_39 + _diagram_5);
                            String _plus_41 = (_plus_40 + "\']");
                            Object _containerStringSearch_2 = this.getContainerStringSearch(mmPackage, annotation, keyValue[1]);
                            String _plus_42 = (_plus_41 + _containerStringSearch_2);
                            String _plus_43 = (_plus_42 + "/@borderedNodeMappings[name=\'");
                            String _get_8 = keyValue[0];
                            String _plus_44 = (_plus_43 + _get_8);
                            String _plus_45 = (_plus_44 + "\'] ");
                            str = _plus_45;
                            for (final EAnnotationImpl r_1 : containers) {
                              String _viewpoint_6 = this.getViewpoint(mmPackage);
                              String _plus_46 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_6);
                              String _plus_47 = (_plus_46 + "\']/@ownedRepresentations[name=\'");
                              String _diagram_6 = this.getDiagram(mmPackage);
                              String _plus_48 = (_plus_47 + _diagram_6);
                              String _plus_49 = (_plus_48 + "\']");
                              Object _containerStringSearch_3 = this.getContainerStringSearch(mmPackage, annotation, keyValue[1]);
                              String _plus_50 = (_plus_49 + _containerStringSearch_3);
                              String _plus_51 = (_plus_50 + "/@subContainerMappings[name=\'");
                              String _get_9 = r_1.getDetails().get("name");
                              String _plus_52 = (_plus_51 + _get_9);
                              String _plus_53 = (_plus_52 + "\']");
                              String _plus_54 = (_plus_53 + "/@borderedNodeMappings[name=\'");
                              String _get_10 = keyValue[0];
                              String _plus_55 = (_plus_54 + _get_10);
                              String _plus_56 = (_plus_55 + "\'] ");
                              str = _plus_56;
                            }
                          } else {
                            String _source_2 = annotation.getSource();
                            boolean _equals_3 = Objects.equal(_source_2, "sirius.container");
                            if (_equals_3) {
                              String _get_11 = annotation.getDetails().get("mapping");
                              boolean _tripleNotEquals_1 = (_get_11 != null);
                              if (_tripleNotEquals_1) {
                                String _viewpoint_7 = this.getViewpoint(mmPackage);
                                String _plus_57 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_7);
                                String _plus_58 = (_plus_57 + "\']/@ownedRepresentations[name=\'");
                                String _diagram_7 = this.getDiagram(mmPackage);
                                String _plus_59 = (_plus_58 + _diagram_7);
                                String _plus_60 = (_plus_59 + "\']");
                                Object _containerStringSearch_4 = this.getContainerStringSearch(mmPackage, annotation, keyValue[1]);
                                String _plus_61 = (_plus_60 + _containerStringSearch_4);
                                String _plus_62 = (_plus_61 + " ");
                                str = _plus_62;
                              } else {
                                String _viewpoint_8 = this.getViewpoint(mmPackage);
                                String _plus_63 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_8);
                                String _plus_64 = (_plus_63 + "\']/@ownedRepresentations[name=\'");
                                String _diagram_8 = this.getDiagram(mmPackage);
                                String _plus_65 = (_plus_64 + _diagram_8);
                                String _plus_66 = (_plus_65 + "\']");
                                Object _containerStringSearch_5 = this.getContainerStringSearch(mmPackage, annotation, keyValue[1]);
                                String _plus_67 = (_plus_66 + _containerStringSearch_5);
                                String _plus_68 = (_plus_67 + " ");
                                str = _plus_68;
                              }
                            }
                          }
                        }
                      }
                    } else {
                      if ((Objects.equal(keyValue[0], annotation.getDetails().get("name")) && ArrayExtensions.contains(annotationContainers, keyValue[1]))) {
                        String _source_3 = annotation.getSource();
                        boolean _equals_4 = Objects.equal(_source_3, "sirius.node");
                        if (_equals_4) {
                          String _viewpoint_9 = this.getViewpoint(mmPackage);
                          String _plus_69 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_9);
                          String _plus_70 = (_plus_69 + "\']/@ownedRepresentations[name=\'");
                          String _diagram_9 = this.getDiagram(mmPackage);
                          String _plus_71 = (_plus_70 + _diagram_9);
                          String _plus_72 = (_plus_71 + "\']");
                          Object _containerString = this.getContainerString(mmPackage, element, annotation);
                          String _plus_73 = (_plus_72 + _containerString);
                          String _plus_74 = (_plus_73 + "/@subNodeMappings[name=\'");
                          String _get_12 = keyValue[0];
                          String _plus_75 = (_plus_74 + _get_12);
                          String _plus_76 = (_plus_75 + "\'] ");
                          str = _plus_76;
                          for (final EAnnotationImpl r_2 : containers) {
                            String _viewpoint_10 = this.getViewpoint(mmPackage);
                            String _plus_77 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_10);
                            String _plus_78 = (_plus_77 + "\']/@ownedRepresentations[name=\'");
                            String _diagram_10 = this.getDiagram(mmPackage);
                            String _plus_79 = (_plus_78 + _diagram_10);
                            String _plus_80 = (_plus_79 + "\']");
                            Object _containerString_1 = this.getContainerString(mmPackage, element, annotation);
                            String _plus_81 = (_plus_80 + _containerString_1);
                            String _plus_82 = (_plus_81 + "/@subContainerMappings[name=\'");
                            String _get_13 = r_2.getDetails().get("name");
                            String _plus_83 = (_plus_82 + _get_13);
                            String _plus_84 = (_plus_83 + "\']");
                            String _plus_85 = (_plus_84 + "/@subNodeMappings[name=\'");
                            String _get_14 = keyValue[0];
                            String _plus_86 = (_plus_85 + _get_14);
                            String _plus_87 = (_plus_86 + "\'] ");
                            str = _plus_87;
                          }
                        } else {
                          String _source_4 = annotation.getSource();
                          boolean _equals_5 = Objects.equal(_source_4, "sirius.borderednode");
                          if (_equals_5) {
                            String _viewpoint_11 = this.getViewpoint(mmPackage);
                            String _plus_88 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_11);
                            String _plus_89 = (_plus_88 + "\']/@ownedRepresentations[name=\'");
                            String _diagram_11 = this.getDiagram(mmPackage);
                            String _plus_90 = (_plus_89 + _diagram_11);
                            String _plus_91 = (_plus_90 + "\']");
                            Object _containerString_2 = this.getContainerString(mmPackage, element, annotation);
                            String _plus_92 = (_plus_91 + _containerString_2);
                            String _plus_93 = (_plus_92 + "/@borderedNodeMappings[name=\'");
                            String _get_15 = keyValue[0];
                            String _plus_94 = (_plus_93 + _get_15);
                            String _plus_95 = (_plus_94 + "\'] ");
                            str = _plus_95;
                            for (final EAnnotationImpl r_3 : containers) {
                              String _viewpoint_12 = this.getViewpoint(mmPackage);
                              String _plus_96 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_12);
                              String _plus_97 = (_plus_96 + "\']/@ownedRepresentations[name=\'");
                              String _diagram_12 = this.getDiagram(mmPackage);
                              String _plus_98 = (_plus_97 + _diagram_12);
                              String _plus_99 = (_plus_98 + "\']");
                              Object _containerString_3 = this.getContainerString(mmPackage, element, annotation);
                              String _plus_100 = (_plus_99 + _containerString_3);
                              String _plus_101 = (_plus_100 + "/@subContainerMappings[name=\'");
                              String _get_16 = r_3.getDetails().get("name");
                              String _plus_102 = (_plus_101 + _get_16);
                              String _plus_103 = (_plus_102 + "\']");
                              String _plus_104 = (_plus_103 + "/@borderedNodeMappings[name=\'");
                              String _get_17 = keyValue[0];
                              String _plus_105 = (_plus_104 + _get_17);
                              String _plus_106 = (_plus_105 + "\'] ");
                              str = _plus_106;
                            }
                          } else {
                            String _source_5 = annotation.getSource();
                            boolean _equals_6 = Objects.equal(_source_5, "sirius.container");
                            if (_equals_6) {
                              String _get_18 = annotation.getDetails().get("mapping");
                              boolean _tripleNotEquals_2 = (_get_18 != null);
                              if (_tripleNotEquals_2) {
                                String _viewpoint_13 = this.getViewpoint(mmPackage);
                                String _plus_107 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_13);
                                String _plus_108 = (_plus_107 + "\']/@ownedRepresentations[name=\'");
                                String _diagram_13 = this.getDiagram(mmPackage);
                                String _plus_109 = (_plus_108 + _diagram_13);
                                String _plus_110 = (_plus_109 + "\']");
                                Object _containerString_4 = this.getContainerString(mmPackage, element, annotation);
                                String _plus_111 = (_plus_110 + _containerString_4);
                                String _plus_112 = (_plus_111 + " ");
                                str = _plus_112;
                              } else {
                                String _viewpoint_14 = this.getViewpoint(mmPackage);
                                String _plus_113 = ((str + "//@ownedViewpoints[name=\'") + _viewpoint_14);
                                String _plus_114 = (_plus_113 + "\']/@ownedRepresentations[name=\'");
                                String _diagram_14 = this.getDiagram(mmPackage);
                                String _plus_115 = (_plus_114 + _diagram_14);
                                String _plus_116 = (_plus_115 + "\']");
                                Object _containerString_5 = this.getContainerString(mmPackage, element, annotation);
                                String _plus_117 = (_plus_116 + _containerString_5);
                                String _plus_118 = (_plus_117 + " ");
                                str = _plus_118;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return str;
  }
  
  private ArrayList<EAnnotationImpl> getReusedContainers(final NoSQL_SchemaPackage mmPackage) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    ArrayList<EAnnotationImpl> containerArr = CollectionLiterals.<EAnnotationImpl>newArrayList();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer c : _doubleDotLessThan) {
      {
        final EObject element = contents.get((c).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            if ((Objects.equal(annotation.getSource(), "sirius.container") && (annotation.getDetails().get("mapping") != null))) {
              containerArr.add(annotation);
            }
          }
        }
      }
    }
    return containerArr;
  }
  
  private Object getContainerString(final NoSQL_SchemaPackage mmPackage, final EObject o, final EAnnotationImpl objectAnnotation) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer c : _doubleDotLessThan) {
      {
        final EObject element = contents.get((c).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            final String container = annotation.getDetails().get("name");
            final String[] objectContainers = objectAnnotation.getDetails().get("container").split(", ");
            if ((Objects.equal(objectAnnotation.getDetails().get("container"), "default") && Objects.equal(annotation.getSource(), "sirius.container"))) {
              return (("/@defaultLayer/@containerMappings[name=\'" + container) + "\']");
            } else {
              if ((ArrayExtensions.contains(objectContainers, container) && Objects.equal(objectAnnotation.getSource(), "sirius.container"))) {
                Object _containerString = this.getContainerString(mmPackage, element, annotation);
                String _plus = (_containerString + "/@subContainerMappings[name=\'");
                String _get = objectAnnotation.getDetails().get("name");
                String _plus_1 = (_plus + _get);
                return (_plus_1 + "\']");
              } else {
                boolean _contains = ArrayExtensions.contains(objectContainers, container);
                if (_contains) {
                  return this.getContainerString(mmPackage, element, annotation);
                }
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  private Object getContainerStringSearch(final NoSQL_SchemaPackage mmPackage, final EAnnotationImpl objectAnnotation, final String search) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer c : _doubleDotLessThan) {
      {
        final EObject element = contents.get((c).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            final String container = annotation.getDetails().get("name");
            final String[] objectContainers = objectAnnotation.getDetails().get("container").split(", ");
            if ((Objects.equal(objectAnnotation.getDetails().get("container"), "default") && Objects.equal(annotation.getSource(), "sirius.container"))) {
              return (("/@defaultLayer/@containerMappings[name=\'" + container) + "\']");
            } else {
              if (((ArrayExtensions.contains(objectContainers, container) && Objects.equal(objectAnnotation.getSource(), "sirius.container")) && Objects.equal(container, search))) {
                Object _containerString = this.getContainerString(mmPackage, element, annotation);
                String _plus = (_containerString + "/@subContainerMappings[name=\'");
                String _get = objectAnnotation.getDetails().get("name");
                String _plus_1 = (_plus + _get);
                return (_plus_1 + "\']");
              } else {
                if ((ArrayExtensions.contains(objectContainers, container) && Objects.equal(container, search))) {
                  return this.getContainerString(mmPackage, element, annotation);
                }
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  private String getAlternateEdge(final NoSQL_SchemaPackage mmPackage, final EAnnotationImpl objectAnnotation) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    String str = "";
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer c : _doubleDotLessThan) {
      {
        final EObject element = contents.get((c).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            if ((((annotation.getDetails().get("belongsto") != null) && Objects.equal(annotation.getDetails().get("belongsto"), objectAnnotation.getDetails().get("name"))) && Objects.equal(annotation.getSource(), "sirius.altedge"))) {
              String _str = str;
              CharSequence _alternateEdgeString = this.getAlternateEdgeString(annotation, objectAnnotation);
              str = (_str + _alternateEdgeString);
            }
          }
        }
      }
    }
    return str;
  }
  
  private String getAlternateNode(final NoSQL_SchemaPackage mmPackage, final EAnnotationImpl objectAnnotation) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    String str = "";
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer c : _doubleDotLessThan) {
      {
        final EObject element = contents.get((c).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            if ((((annotation.getDetails().get("belongsto") != null) && Objects.equal(annotation.getDetails().get("belongsto"), objectAnnotation.getDetails().get("name"))) && Objects.equal(annotation.getSource(), "sirius.altnode"))) {
              String _str = str;
              CharSequence _alternateNodeString = this.getAlternateNodeString(annotation, objectAnnotation);
              str = (_str + _alternateNodeString);
            }
          }
        }
      }
    }
    return str;
  }
  
  private CharSequence getAlternateEdgeString(final EAnnotationImpl AlternateEdge, final EAnnotationImpl SourceEdge) {
    StringConcatenation _builder = new StringConcatenation();
    final String alternateColor = AlternateEdge.getDetails().get("color");
    _builder.newLineIfNotEmpty();
    _builder.append("<conditionnalStyles predicateExpression=\"");
    String _get = AlternateEdge.getDetails().get("condition");
    _builder.append(_get);
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<style sizeComputationExpression=\"2\">");
    _builder.newLine();
    {
      if ((alternateColor != null)) {
        _builder.append("\t    ");
        _builder.append("<strokeColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
        _builder.append(alternateColor, "\t    ");
        _builder.append("\']\"/>");
        _builder.newLineIfNotEmpty();
      } else {
        {
          String _get_1 = SourceEdge.getDetails().get("color");
          boolean _tripleNotEquals = (_get_1 != null);
          if (_tripleNotEquals) {
            _builder.append("\t    ");
            _builder.append("<strokeColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
            String _get_2 = SourceEdge.getDetails().get("color");
            _builder.append(_get_2, "\t    ");
            _builder.append("\']\"/>");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t    ");
            _builder.append("<strokeColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'grey\']\"/>");
            _builder.newLine();
          }
        }
      }
    }
    {
      String _get_3 = AlternateEdge.getDetails().get("label");
      boolean _tripleNotEquals_1 = (_get_3 != null);
      if (_tripleNotEquals_1) {
        _builder.append("    ");
        _builder.append("<centerLabelStyleDescription labelSize=\"12\" showIcon=\"false\" labelExpression=\"");
        String _get_4 = AlternateEdge.getDetails().get("label");
        _builder.append(_get_4, "    ");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("    ");
        _builder.append("<centerLabelStyleDescription labelSize=\"12\" showIcon=\"false\" labelExpression=\"");
        String _get_5 = SourceEdge.getDetails().get("label");
        _builder.append(_get_5, "    ");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</centerLabelStyleDescription>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</style>");
    _builder.newLine();
    _builder.append("</conditionnalStyles>");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence getAlternateNodeString(final EAnnotationImpl AlternateNode, final EAnnotationImpl SourceNode) {
    StringConcatenation _builder = new StringConcatenation();
    final String alternateColor = AlternateNode.getDetails().get("color");
    _builder.newLineIfNotEmpty();
    final String label = AlternateNode.getDetails().get("label");
    _builder.newLineIfNotEmpty();
    _builder.append("<conditionnalStyles predicateExpression=\"");
    String _get = AlternateNode.getDetails().get("condition");
    _builder.append(_get);
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<style xsi:type=\"style:");
    String _get_1 = AlternateNode.getDetails().get("style");
    _builder.append(_get_1, "\t");
    _builder.append("\" labelSize=\"12\" ");
    {
      if ((label != null)) {
        _builder.append("labelExpression=\"");
        String _get_2 = AlternateNode.getDetails().get("label");
        _builder.append(_get_2, "\t");
        _builder.append("\" ");
      } else {
        _builder.append("labelExpression=\"");
        String _get_3 = SourceNode.getDetails().get("label");
        _builder.append(_get_3, "\t");
        _builder.append("\" ");
      }
    }
    _builder.append("labelPosition=\"node\" resizeKind=\"NSEW\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<borderColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
    _builder.newLine();
    {
      if ((alternateColor != null)) {
        _builder.append("        \t");
        _builder.append("<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
        _builder.append(alternateColor, "        \t");
        _builder.append("\']\"/>");
        _builder.newLineIfNotEmpty();
      } else {
        {
          String _get_4 = SourceNode.getDetails().get("color");
          boolean _tripleNotEquals = (_get_4 != null);
          if (_tripleNotEquals) {
            _builder.append("        \t");
            _builder.append("<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'");
            String _get_5 = SourceNode.getDetails().get("color");
            _builder.append(_get_5, "        \t");
            _builder.append("\']\"/>");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("        \t");
            _builder.append("<labelColor xsi:type=\"description:SystemColor\" href=\"environment:/viewpoint#//@systemColors/@entries[name=\'black\']\"/>");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("</style>");
    _builder.newLine();
    _builder.append("</conditionnalStyles>");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence getDecorations(final NoSQL_SchemaPackage mmPackage) {
    final List<EObject> contents = IteratorExtensions.<EObject>toList(mmPackage.eAllContents());
    ArrayList<EAnnotationImpl> arr = CollectionLiterals.<EAnnotationImpl>newArrayList();
    int _size = contents.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer c : _doubleDotLessThan) {
      {
        final EObject element = contents.get((c).intValue());
        final EList<EObject> elementContents = element.eContents();
        final List<EAnnotationImpl> annotations = IterableExtensions.<EAnnotationImpl>toList(Iterables.<EAnnotationImpl>filter(elementContents, EAnnotationImpl.class));
        int _size_1 = annotations.size();
        ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
        for (final Integer k : _doubleDotLessThan_1) {
          {
            final EAnnotationImpl annotation = annotations.get((k).intValue());
            String _source = annotation.getSource();
            boolean _equals = Objects.equal(_source, "sirius.decoration");
            if (_equals) {
              arr.add(annotation);
            }
          }
        }
      }
    }
    int _size_1 = arr.size();
    boolean _greaterThan = (_size_1 > 0);
    if (_greaterThan) {
      return this.getDecorationString(arr, mmPackage);
    }
    return "";
  }
  
  private CharSequence getDecorationString(final ArrayList<EAnnotationImpl> arr, final NoSQL_SchemaPackage mmPackage) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<decorationDescriptionsSet>");
    _builder.newLine();
    {
      for(final EAnnotationImpl objectAnnotation : arr) {
        _builder.append("<decorationDescriptions xsi:type=\"description_1:MappingBasedDecoration\" name=\"");
        String _get = objectAnnotation.getDetails().get("name");
        _builder.append(_get);
        _builder.append("\" position=\"");
        String _get_1 = objectAnnotation.getDetails().get("position");
        _builder.append(_get_1);
        _builder.append("\" preconditionExpression=\"");
        String _get_2 = objectAnnotation.getDetails().get("expression");
        _builder.append(_get_2);
        _builder.append("\" imageExpression=\"/");
        String _path = this.getPath(mmPackage);
        _builder.append(_path);
        _builder.append("/");
        String _get_3 = objectAnnotation.getDetails().get("image");
        _builder.append(_get_3);
        _builder.append("\" mappings=\"");
        String _mappingString = this.getMappingString(mmPackage, objectAnnotation, "mappings");
        _builder.append(_mappingString);
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</decorationDescriptionsSet>");
    _builder.newLine();
    return _builder;
  }
  
  private String getToolString(final EAnnotationImpl objectAnnotation, final String viewpoint, final String diagram) {
    String str = "";
    final String value = objectAnnotation.getDetails().get("name");
    str = (((((("//@ownedViewpoints[name=\'" + viewpoint) + "\']/@ownedRepresentations[name=\'") + diagram) + "\']/@defaultLayer/@toolSections.0/@ownedTools[name=\'") + value) + "\'] ");
    return str;
  }
}
