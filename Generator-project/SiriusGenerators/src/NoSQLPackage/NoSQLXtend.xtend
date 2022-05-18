package NoSQLPackage

import NoSQL_Schema.NoSQL_SchemaPackage
import com.google.inject.Inject
import java.util.ArrayList
import javax.inject.Provider
import org.eclipse.emf.ecore.EAnnotation
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.impl.EAnnotationImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.GeneratorContext
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

public class NoSQLPackage {
	@Inject
	private static Provider<IFileSystemAccess2> fileSystemAccessProvider;
	def static void main(String[] args)
	{
		val gen = new NoSQLGenerator;
		
		//For checking the data from the metamodel
		val temp = NoSQL_SchemaPackage.eINSTANCE;
		val charseq = gen.compile(temp)
		val context = new GeneratorContext();
		//Print out in console
		println(charseq)
	}

}

class NoSQLGenerator extends AbstractGenerator {
	
	//TODO Change the the strings to be in functions instead of directly in compile
	//If there is time clean this function
	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		//Replace with input if possible
		val MetaModel = NoSQL_SchemaPackage.eINSTANCE;
		fsa.generateFile(MetaModel.name + ".odesign", MetaModel.compile)
	}
	
	public def compile(NoSQL_SchemaPackage mmPackage) '''
		<?xml version="1.0" encoding="UTF-8"?>
		«val viewpoint = getViewpoint(mmPackage)»
		«val diagram = getDiagram(mmPackage)»
		«val fileextension = getExtension(mmPackage).toLowerCase()»
		<description:Group xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:description="http://www.eclipse.org/sirius/description/1.1.0" xmlns:description_1="http://www.eclipse.org/sirius/diagram/description/1.1.0" xmlns:properties="http://www.eclipse.org/sirius/properties/1.0.0" xmlns:style="http://www.eclipse.org/sirius/diagram/description/style/1.1.0" xmlns:tool="http://www.eclipse.org/sirius/diagram/description/tool/1.1.0" xmlns:tool_1="http://www.eclipse.org/sirius/description/tool/1.1.0" name="NoSQL_Schema" version="12.0.0.2017041100">
		<ownedViewpoints name="«viewpoint»" modelFileExtension="«fileextension»">
		  «val mainclass = getMainClass(mmPackage)»
		  	    <ownedRepresentations xsi:type="description_1:DiagramDescription" name="«diagram»" domainClass="«mmPackage.name»::«mainclass»">
		  	    <metamodel href="«mmPackage.nsURI»"/>
		  	    <defaultLayer name="Default">
		  	    «val nodes = getNodes(mmPackage)»
		  	    «FOR n : nodes»
		  	    «val nodeAnnotation = getNodeAnnotation(n)»
		  	    «var border = nodeAnnotation.details.get("bordercolor")»
		  	    «var labelcolor = nodeAnnotation.details.get("labelcolor")»
		  	  	«val editNameAnnotations = getToolsAnnotation(mmPackage, "DirectEditLabel", nodeAnnotation.details.get("name"), nodeAnnotation)»
		  	  	«val label = nodeAnnotation.details.get("label")»
		  	  	«val icon = nodeAnnotation.details.get("icon")»
		  	    	<nodeMappings name="«nodeAnnotation.details.get("name")»"«IF editNameAnnotations !== null» labelDirectEdit="«getToolString(editNameAnnotations, viewpoint, diagram)»"«ENDIF» semanticCandidatesExpression="«nodeAnnotation.details.get("expression")»" domainClass="«mmPackage.name»::«nodeAnnotation.details.get("domain")»">
		  	    		<style xsi:type="style:«nodeAnnotation.details.get("style")»" labelSize="12" «IF label !==null » labelExpression="«label»" «ENDIF» «IF icon !== null »showIcon="«nodeAnnotation.details.get("icon")»" «ENDIF» labelPosition="node" sizeComputationExpression="2" resizeKind="NSEW" «getNodeWidth(nodeAnnotation)» «getNodeHeight(nodeAnnotation)»>
		  	    			«IF border.isNullOrEmpty»
		  	    			<borderColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
		  	    			«ELSE»
		  	    			<borderColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«border»']"/>
		  	    			«ENDIF»
		  	    			«IF labelcolor.isNullOrEmpty»
		  	    			<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
		  	    			«ELSE»
		  	    			<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«labelcolor»']"/>
		  	    			«ENDIF»
		  	    			«getNodeColorString(nodeAnnotation)»
		  	    		</style>
		  	    		«getAlternateNode(mmPackage, nodeAnnotation)»
		  	    	</nodeMappings>
		  	    «ENDFOR»		  	    
		  	    «val edges = getEdges(mmPackage)»
		  	    «FOR e : edges»
		  	    	«val edgeAnnotations = getEdgeAnnotation(e)»
		  	    	«val deleteAnnotations = getToolsAnnotation(mmPackage, "DeleteElementDescription", edgeAnnotations.details.get("name"), edgeAnnotations)»
		  	    	«val reconnectAnnotation = getToolsAnnotation(mmPackage, "ReconnectEdgeDescription", edgeAnnotations.details.get("name"), edgeAnnotations)»
		  	    	«var color = edgeAnnotations.details.get("color")»
		  	    	«var label = edgeAnnotations.details.get("label")»
		  	    	«var labelcolor = edgeAnnotations.details.get("labelcolor")»
		  	    	«val targetStyle = edgeAnnotations.details.get("targetStyle")»
		  	    	«val sourceStyle = edgeAnnotations.details.get("sourceStyle")»
		  	    	«val icon = edgeAnnotations.details.get("icon")»
		  	    	«IF edgeAnnotations.details.get("type") == "element"»
		  	    	<edgeMappings name="«edgeAnnotations.details.get("name")»" «IF deleteAnnotations !== null» deletionDescription="«getToolString(deleteAnnotations, viewpoint, diagram)»" «ENDIF» «IF reconnectAnnotation !== null» «val tools =getReconnectionTools(mmPackage, "ReconnectEdgeDescription", edgeAnnotations.details.get("name"))» reconnections="«FOR t : tools»«getToolString(t, viewpoint, diagram)»«ENDFOR»" «ENDIF» semanticCandidatesExpression="«edgeAnnotations.details.get("expression")»" sourceMapping="«getMappingString(mmPackage, edgeAnnotations, "source")»" targetMapping="«getMappingString(mmPackage, edgeAnnotations, "target")»" targetFinderExpression="«edgeAnnotations.details.get("targetFinderExpression")»" sourceFinderExpression="«edgeAnnotations.details.get("sourceFinderExpression")»" domainClass="«mmPackage.name»::«edgeAnnotations.details.get("domain")»" useDomainElement="true">
		  	    	<style «IF targetStyle !== null»targetArrow="«edgeAnnotations.details.get("targetStyle")»" «ENDIF» «IF sourceStyle !== null»sourceArrow="«edgeAnnotations.details.get("sourceStyle")»" «ENDIF» sizeComputationExpression="2">
		  	    			«IF color.isNullOrEmpty»
		  	    			<strokeColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
		  	    			«ELSE»
		  	    			<strokeColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«color»']"/>
		  	    			«ENDIF»
		  	    	<centerLabelStyleDescription labelSize="12" «IF icon !== null»showIcon="«edgeAnnotations.details.get("icon")»" «ENDIF» «IF label !== null» labelExpression="«edgeAnnotations.details.get("label")» «ENDIF»">
				  	    		«IF labelcolor.isNullOrEmpty» 			<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
					  	    	«ELSE»			<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«labelcolor»']"/>
				  	    		«ENDIF»
		  	    	</centerLabelStyleDescription>
		  	    	</style>
		  	    	«ELSE»
		  	    	<edgeMappings name="«edgeAnnotations.details.get("name")»" «IF deleteAnnotations !== null» deletionDescription="«getToolString(deleteAnnotations, viewpoint, diagram)»" «ENDIF» «IF reconnectAnnotation !== null» reconnections="«getToolString(reconnectAnnotation, viewpoint, diagram)»" «ENDIF» sourceMapping="«getMappingString(mmPackage, edgeAnnotations, "source")»" targetMapping="«getMappingString(mmPackage, edgeAnnotations, "target")»" targetFinderExpression="«edgeAnnotations.details.get("targetFinderExpression")»">
		  	    	<style «IF targetStyle !== null»targetArrow="«edgeAnnotations.details.get("targetStyle")»" «ENDIF» «IF sourceStyle !== null»sourceArrow="«edgeAnnotations.details.get("sourceStyle")»" «ENDIF» sizeComputationExpression="2">
		  	    			«IF color.isNullOrEmpty»
		  	    			<strokeColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
		  	    			«ELSE»
		  	    			<strokeColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«color»']"/>
		  	    			«ENDIF»
		  	    				<centerLabelStyleDescription labelSize="12" «IF icon !== null»showIcon="«edgeAnnotations.details.get("icon")»" «ENDIF» «IF label !== null» labelExpression="«edgeAnnotations.details.get("label")»"«ENDIF»>
				  	    		«IF labelcolor.isNullOrEmpty» 			<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
					  	    	«ELSE»			<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«labelcolor»']"/>
				  	    		«ENDIF»
		  	    	            </centerLabelStyleDescription>
		  	    		</style>
		  	    	«ENDIF»
			         «getAlternateEdge(mmPackage, edgeAnnotations)»
		  	    	</edgeMappings>
		  	    «ENDFOR»
		  	    «val containers = getContainers(mmPackage)»		  	    
		  	    «FOR c : containers»
		  	    «val containerAnnotations = getContainerAnnotation(c)»
		  	    «val containerContents = getContainerContents(mmPackage, containerAnnotations.details.get("name"))»
		  	    «val editNameAnnotations = getToolsAnnotation(mmPackage, "DirectEditLabel", containerAnnotations.details.get("name"), containerAnnotations)»
		  	    «val presentation = containerAnnotations.details.get("presentation")»
		  	    «val label = containerAnnotations.details.get("label")»
		  	    <containerMappings name="«containerAnnotations.details.get("name")»"«IF editNameAnnotations !== null» «IF label !== null»labelExpression="«label»" «ENDIF» labelDirectEdit="«getToolString(editNameAnnotations, viewpoint, diagram)»"«ENDIF» semanticCandidatesExpression="«containerAnnotations.details.get("expression")»" domainClass="«mmPackage.name»::«containerAnnotations.details.get("domain")»"«IF presentation !== null» childrenPresentation="«presentation»"«ENDIF»>>
		  	        <style xsi:type="style:FlatContainerStyleDescription"  borderSizeComputationExpression="1" labelSize="12" showIcon="false" roundedCorner="true">
		  	        	<borderColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
		  	            <labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
		  	            <backgroundColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«containerAnnotations.details.get("foreground")»']"/>
		  	            <foregroundColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«containerAnnotations.details.get("background")»']"/>
		  	    	</style>
		  	    	«FOR contents : containerContents»
		  	    		«getContentsString(contents, mmPackage)»
		  	    	«ENDFOR»
		  	    </containerMappings>
		  	    «ENDFOR»
		  	    «getDecorations(mmPackage)»
		  	    <toolSections name="Tools">
		  	    «val allNodes = getAllNodes(mmPackage)»
		  	   	«val nodeTools = newArrayList»
		  	    «FOR n : allNodes»
		  	    	«var nodeAnnotation = getNodeAnnotation(n)»
		  	    	«IF nodeAnnotation === null»
		  	    	«nodeAnnotation = getBorderedNodeAnnotation(n)»
		  	    	«ENDIF»
		  	    	«val toolAnnotation = getToolsAnnotation(mmPackage, "NodeCreationDescription", nodeAnnotation.details.get("name"), nodeAnnotation)»
		  	    	«IF toolAnnotation !== null»
		  	    	«IF !nodeTools.contains(toolAnnotation)»
		  	    	«nodeTools.add(toolAnnotation)»
		  	    	«val nameAnnotation = toolAnnotation.details.get("nodename")»
		  	    	«val label= toolAnnotation.details.get("label")»
		  	    	«val changeFeature = toolAnnotation.details.get("changeFeature")»
		  	    	«val additionalFeature = toolAnnotation.details.get("additionalFeature")»
		  	    	<ownedTools xsi:type="tool:«toolAnnotation.details.get("type")»" name="«toolAnnotation.details.get("name")»" «IF label !== null» label="«label»" «ENDIF» nodeMappings="«getMappingString(mmPackage, toolAnnotation, "mappings")»">
		  	    		<variable name="container"/>
		  	    		<viewVariable name="containerView"/>
		  	    			<initialOperation>
		  	    				<firstModelOperations xsi:type="tool_1:ChangeContext" browseExpression="var:container">
		  	    					<subModelOperations xsi:type="tool_1:CreateInstance" typeName="«mmPackage.name»::«nodeAnnotation.details.get("domain")»" referenceName="«toolAnnotation.details.get("reference")»">
		  	    						«IF nameAnnotation !== null»<subModelOperations xsi:type="tool_1:SetValue" featureName="name" valueExpression="«toolAnnotation.details.get("nodename")»"/>«ENDIF»
		  	    						«IF changeFeature !== null»
		  	    						<subModelOperations xsi:type="tool_1:SetValue" featureName="«changeFeature»" valueExpression="«toolAnnotation.details.get("changeValue")»"/>
		  	    						«ENDIF»
		  	    						«IF additionalFeature !== null»
		  	    						<subModelOperations xsi:type="tool_1:CreateInstance" typeName="«mmPackage.name»::«toolAnnotation.details.get("additionalInstance")»" referenceName="«additionalFeature»"/>
		  	    						«ENDIF»
		  	    					</subModelOperations>
		  	    				</firstModelOperations>
		  	    			</initialOperation>
		  	    	</ownedTools>
		  	    	«ENDIF»
		  	    	«ENDIF»
		  	     «ENDFOR»
			 	 «FOR e : edges»
             	«val edgeAnnotation = getEdgeAnnotation(e)»
             	«val toolAnnotation = getToolsAnnotation(mmPackage, "EdgeCreationDescription", edgeAnnotation.details.get("name"), edgeAnnotation)»
             	«IF toolAnnotation !== null»
             	«val changeFeature = toolAnnotation.details.get("changeFeature")»
             	«val additionalFeature = toolAnnotation.details.get("additionalFeature")»
             	«IF edgeAnnotation.details.get("type") == "relation"»
             	 <ownedTools xsi:type="tool:«toolAnnotation.details.get("type")»" name="«toolAnnotation.details.get("name")»" edgeMappings="//@ownedViewpoints[name='«viewpoint»']/@ownedRepresentations[name='«diagram»']/@defaultLayer/@edgeMappings[name='«toolAnnotation.details.get("mappings")»']">
             	 	<sourceVariable name="source"/>
             	 	<targetVariable name="target"/>
             	 	<sourceViewVariable name="sourceView"/>
             	 	<targetViewVariable name="targetView"/>
             	 	<initialOperation>
             	 		<firstModelOperations xsi:type="tool_1:ChangeContext" browseExpression="var:source">
             	 			<subModelOperations xsi:type="tool_1:SetValue" featureName="«toolAnnotation.details.get("feature")»" valueExpression="var:target"/>
             	 		</firstModelOperations>
             	 	</initialOperation>
             	 </ownedTools>
                	«ELSE»
		          <ownedTools xsi:type="tool:«toolAnnotation.details.get("type")»" name="«toolAnnotation.details.get("name")»" edgeMappings="//@ownedViewpoints[name='«viewpoint»']/@ownedRepresentations[name='«diagram»']/@defaultLayer/@edgeMappings[name='«toolAnnotation.details.get("mappings")»']">
		            <sourceVariable name="source"/>
		            <targetVariable name="target"/>
		            <sourceViewVariable name="sourceView"/>
		            <targetViewVariable name="targetView"/>
		            <initialOperation>
		            «val container = toolAnnotation.details.get("containerexpression")»
		            «IF container !== null»<firstModelOperations xsi:type="tool_1:ChangeContext" browseExpression="«toolAnnotation.details.get("containerexpression")»">
		            <subModelOperations xsi:type="tool_1:CreateInstance" typeName="«mmPackage.name»::«edgeAnnotation.details.get("domain")»" referenceName="«toolAnnotation.details.get("reference")»">
					«ELSE»
		            <firstModelOperations xsi:type="tool_1:CreateInstance" typeName="«mmPackage.name»::«edgeAnnotation.details.get("domain")»" referenceName="«toolAnnotation.details.get("reference")»">
					«ENDIF»
		                <subModelOperations xsi:type="tool_1:SetValue" featureName="«toolAnnotation.details.get("source")»" valueExpression="var:source"/>
		                <subModelOperations xsi:type="tool_1:SetValue" featureName="«toolAnnotation.details.get("target")»" valueExpression="var:target"/>
		                «IF changeFeature !== null»
		                <subModelOperations xsi:type="tool_1:SetValue" featureName="«changeFeature»" valueExpression="«toolAnnotation.details.get("changeValue")»"/>
		                «ENDIF»
		                «IF changeFeature !== null»
		                <subModelOperations xsi:type="tool_1:CreateInstance" typeName="«mmPackage.name»::«toolAnnotation.details.get("additionalInstance")»" referenceName="«additionalFeature»"/>
		                «ENDIF»
		             	«IF container !== null»</subModelOperations>«ENDIF»
		             </firstModelOperations>
		            </initialOperation>
		          </ownedTools>
                	«ENDIF»
                	«ENDIF»
             	 «ENDFOR»
                 «FOR e: edges»
                    «val edgeAnnotation = getEdgeAnnotation(e)»
                    «val toolAnnotation = getToolsAnnotation(mmPackage, "DeleteElementDescription", edgeAnnotation.details.get("name"), edgeAnnotation)»
                    «IF toolAnnotation !== null»
                    <ownedTools xsi:type="tool:«toolAnnotation.details.get("type")»" name="«toolAnnotation.details.get("name")»">
                    <element name="element"/>
                        		<elementView name="elementView"/>
                                <containerView name="containerView"/>
                                <initialOperation>
                                	<firstModelOperations xsi:type="tool_1:ChangeContext" browseExpression="var:element">
                                    	<subModelOperations xsi:type="tool_1:Unset" featureName="«toolAnnotation.details.get("feature")»"/>
                                    </firstModelOperations>
                                </initialOperation>
                    </ownedTools>
                    «ENDIF»
                    «ENDFOR»
                 «FOR e: edges»
                    «val edgeAnnotation = getEdgeAnnotation(e)»
                    «val toolAnnotation = getToolsAnnotation(mmPackage, "ReconnectEdgeDescription", edgeAnnotation.details.get("name"), edgeAnnotation)»
                    «IF toolAnnotation !== null»
                    «val tools = getReconnectionTools(mmPackage, "ReconnectEdgeDescription", edgeAnnotation.details.get("name"))»
                    «FOR t : tools»
                    «val unsetFeature=t.details.get("unsetFeature")»
                    «val reconnectKind = t.details.get("kind")»
                    <ownedTools xsi:type="tool:«t.details.get("type")»" name="«t.details.get("name")»" «IF reconnectKind !== null && reconnectKind == "source"» reconnectionKind="RECONNECT_SOURCE"«ENDIF»>
                    <source name="source"/>
                    <target name="target"/>
                    <sourceView name="sourceView"/>
                    <targetView name="targetView"/>
                    <element name="element"/>
                       <initialOperation>
                       <firstModelOperations xsi:type="tool_1:ChangeContext" browseExpression="var:element">
                       		«IF unsetFeature !== null»
                       		<subModelOperations xsi:type="tool_1:Unset" featureName="«unsetFeature»" elementExpression="«t.details.get("unsetReference")»"/>
                       		«ENDIF»
                       		<subModelOperations xsi:type="tool_1:SetValue" featureName="«t.details.get("feature")»" valueExpression="var:target"/>
                       	</firstModelOperations>
                        </initialOperation>
                    <edgeView name="edgeView"/>
                    </ownedTools>
                    «ENDFOR»
                    «ENDIF»
                    «ENDFOR»
                «val directAnnoTool = getUniversalTool(mmPackage, "DirectEditLabel")»
                «IF directAnnoTool === null»
		  	    «FOR n : nodes»
		  	    «val nodeAnnotation = getNodeAnnotation(n)»
		  	    «val toolAnnotation = getToolsAnnotation(mmPackage, "DirectEditLabel", nodeAnnotation.details.get("name"), nodeAnnotation)»
		  	    «IF toolAnnotation!==null »
		  	    	<ownedTools xsi:type="tool:«toolAnnotation.details.get("type")»" name="«toolAnnotation.details.get("name")»">
		  	    		<mask mask="{0}"/>
		  	    			<initialOperation>
		  	    			<firstModelOperations xsi:type="tool_1:SetValue" featureName="«toolAnnotation.details.get("feature")»" valueExpression="«toolAnnotation.details.get("value")»"/>
		  	    		</initialOperation>
		  	    	</ownedTools>
		  	    «ENDIF»
		  	    «ENDFOR»
		  	    «ELSE»
		  	    	<ownedTools xsi:type="tool:«directAnnoTool.details.get("type")»" name="«directAnnoTool.details.get("name")»">
		  	    		<mask mask="{0}"/>
		  	    		<initialOperation>
		  	    			<firstModelOperations xsi:type="tool_1:SetValue" featureName="«directAnnoTool.details.get("feature")»" valueExpression="«directAnnoTool.details.get("value")»"/>
		  	    		</initialOperation>
		  	    	</ownedTools>
		  	    «ENDIF»
		  	    «val allContainers = getAllContainers(mmPackage)»
		  	    «val containerTools = newArrayList»
		  	    «FOR c : allContainers»
		  	    «val containerAnnotation = getContainerAnnotation(c)»
		  	    «val toolAnnotation = getToolsAnnotation(mmPackage, "ContainerCreationDescription", containerAnnotation.details.get("name"), containerAnnotation)»
		  	    «IF toolAnnotation !== null»
		  	    «IF !containerTools.contains(toolAnnotation)»
		  	    «containerTools.add(toolAnnotation)»
		  	    «val changeFeature = toolAnnotation.details.get("changeFeature")»
		  	    «val additionalFeature = toolAnnotation.details.get("additionalFeature")»
		  	    <ownedTools xsi:type="tool:«toolAnnotation.details.get("type")»" name="«toolAnnotation.details.get("name")»" containerMappings="«getMappingString(mmPackage, toolAnnotation, "mappings")»">
		  	        <variable name="container"/>
		  	        <viewVariable name="containerView"/>
		  	        <initialOperation>
		  	            <firstModelOperations xsi:type="tool_1:ChangeContext" browseExpression="var:container">
		  	            	<subModelOperations xsi:type="tool_1:CreateInstance" typeName="«mmPackage.name»::«containerAnnotation.details.get("domain")»" referenceName="«toolAnnotation.details.get("reference")»"/>
		  	            		«IF changeFeature !== null»
		  	            		<subModelOperations xsi:type="tool_1:SetValue" featureName="«changeFeature»" valueExpression="«toolAnnotation.details.get("changeValue")»"/>
		  	            		«ENDIF»
		  	            		«IF additionalFeature !== null»
		  	            		<subModelOperations xsi:type="tool_1:CreateInstance" typeName="«mmPackage.name»::«toolAnnotation.details.get("additionalInstance")»" referenceName="«additionalFeature»"/>
		  	            		«ENDIF»
		  	        	</firstModelOperations>
		  	     	</initialOperation>
		  	     </ownedTools>
		  	     «ENDIF»
		  	     «ENDIF»
		  	    «ENDFOR»    
		  	    «val doubleClickTools = getUniversalToolGroup(mmPackage, "DoubleClickDescription")»
		  	    «FOR t : doubleClickTools»
		  	    	«getDoubleClickToolString(mmPackage, t)»
		  	    «ENDFOR»
				</toolSections>
				</defaultLayer>
			</ownedRepresentations>
			<ownedJavaExtensions qualifiedClassName="«getPath(mmPackage)».Services"/>
			</ownedViewpoints>
		</description:Group>
	'''
				
	private def getMainClass(NoSQL_SchemaPackage mmPackage)
	{	//Function to get the main class
		//Can use the package directly to access the sirius annotation
		//as the sirius annotation is not connected to any element
		val contents = mmPackage.EAnnotations
		for(i : 0 ..< contents.size())
		{	//Goes through the annotations of the package
			val element = contents.get(i);
			val key = "mainclass"
			//Return when finding the key mainclass
			if(element.details.containsKey(key))
			{
				val value = element.details.get(key)
				return value
			}
		
		}
	}
	
		private def getPath(NoSQL_SchemaPackage mmPackage)
	{	//Function to get the main class
		//Can use the package directly to access the sirius annotation
		//as the sirius annotation is not connected to any element
		val contents = mmPackage.EAnnotations
		for(i : 0 ..< contents.size())
		{	//Goes through the annotations of the package
			val element = contents.get(i);
			val key = "path"
			//Return when finding the key mainclass
			if(element.details.containsKey(key))
			{
				val value = element.details.get(key)
				return value
			}
		
		}
	}
	
	private def getViewpoint(NoSQL_SchemaPackage mmPackage)
	{	
		val contents = mmPackage.EAnnotations
		for(i : 0 ..< contents.size())
		{	
			val element = contents.get(i);
			val key = "viewpoint"

			if(element.details.containsKey(key))
			{
				val value = element.details.get(key)
				return value
			}
			return "viewpoint"
		}
	}
	
		private def getExtension(NoSQL_SchemaPackage mmPackage)
	{	
		val contents = mmPackage.EAnnotations
		for(i : 0 ..< contents.size())
		{	
			val element = contents.get(i);
			val key = "extension"

			if(element.details.containsKey(key))
			{
				val value = element.details.get(key)
				return value
			}
			return mmPackage.name
		}
	}
	
	private def getNodeHeight(EAnnotationImpl NodeAnnotation)
	{
		val height = NodeAnnotation.details.get("height")
		val type = NodeAnnotation.details.get("style")
		if(height !== null)
		{
			if(type == "EllipseNodeDescription")
			{
				return '''verticalDiameterComputationExpression="«height»"'''
			}
			else
			{
				return '''height="«height»"'''
			}
		}
		return ""
	}
	
	private def getNodeWidth(EAnnotationImpl NodeAnnotation)
	{
		val width = NodeAnnotation.details.get("width")
		val type = NodeAnnotation.details.get("style")
		if(width !== null)
		{
			if(type == "EllipseNodeDescription")
			{
				return '''horizontalDiameterComputationExpression="«width»"'''
			}
			else
			{
				return '''width="«width»"'''
			}
		}
		return ""
	}
	
	private def getDiagram(NoSQL_SchemaPackage mmPackage)
	{	
		val contents = mmPackage.EAnnotations
		for(i : 0 ..< contents.size())
		{	
			val element = contents.get(i);
			val key = "diagram"
			if(element.details.containsKey(key))
			{
				val value = element.details.get(key)
				return value
			}
			return "diagram"
		}
	}
	
	private def getNodes(NoSQL_SchemaPackage mmPackage)
	{
		//Get the contents of the package
		val contents = mmPackage.eAllContents.toList()
		//New list to contain the nodes
		val nodes = newArrayList
		for(i : 0 ..< contents.size())
		{
			//Iterate through the contents of the pacakge
			val element = contents.get(i)
			val elementContents = element.eContents
			//Filter the element contents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			//Iterate through the annotations
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				//If it finds an element that has the node annotation add it to the list
				if(annotation.source == "sirius.node" && (annotation.details.get("container") == "default" || annotation.details.get("container") === null))
				{
					nodes.add(element)
				}
			}
			//Goes through the mainclass to see if there is any other nodes that needs to be added
		}
		return nodes
	}
	
	private def getAllNodes(NoSQL_SchemaPackage mmPackage)
	{
		//Get the contents of the package
		val contents = mmPackage.eAllContents.toList()
		//New list to contain the nodes
		val nodes = newArrayList
		for(i : 0 ..< contents.size())
		{
			//Iterate through the contents of the pacakge
			val element = contents.get(i)
			val elementContents = element.eContents
			//Filter the element contents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			//Iterate through the annotations
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				//If it finds an element that has the node annotation add it to the list
				if(annotation.source == "sirius.node" || annotation.source == "sirius.borderednode")
				{
					nodes.add(element)
				}
			}
			//Goes through the mainclass to see if there is any other nodes that needs to be added
		}
		return nodes
	}
	
		private def getAllContainers(NoSQL_SchemaPackage mmPackage)
	{
		//Get the contents of the package
		val contents = mmPackage.eAllContents.toList()
		//New list to contain the nodes
		val nodes = newArrayList
		for(i : 0 ..< contents.size())
		{
			//Iterate through the contents of the pacakge
			val element = contents.get(i)
			val elementContents = element.eContents
			//Filter the element contents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			//Iterate through the annotations
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				//If it finds an element that has the node annotation add it to the list
				if(annotation.source == "sirius.container")
				{
					nodes.add(element)
				}
			}
			//Goes through the mainclass to see if there is any other nodes that needs to be added
		}
		return nodes
	}
	
	private def getContainers(NoSQL_SchemaPackage mmPackage)
	{
		//Get the contents of the package
		val contents = mmPackage.eAllContents.toList()
		//New list to contain the containers
		val containers = newArrayList
		for(i : 0 ..< contents.size())
		{
			//Iterate through the contents of the pacakge
			val element = contents.get(i)
			val elementContents = element.eContents
			//Filter the element contents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			//Iterate through the annotations
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				//If it finds an element that has the container annotation add it to the list, will only listen for initial containers, as others will be added inside their respective container
				if(annotation.source == "sirius.container" && annotation.details.get("container") == "default")
				{
					containers.add(element)
				}
			}
			//Goes through the mainclass to see if there is any other nodes that needs to be added
		}
		return containers
	}
	
	//Goes through contents to find every annotation with the name of the current container
	private def getContainerContents(NoSQL_SchemaPackage mmPackage, String name)
	{
		val contents = mmPackage.eAllContents.toList()
		val containerContents = newArrayList
		for(i : 0 ..< contents.size())
		{
			val element = contents.get(i)
			val elementContents = element.eContents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				if(annotation.details.get("container") !== null)
				{
					val arr = annotation.details.get("container").split(", ")
					for(a : arr)
					{
						if(a == name)
						{
							if(!containerContents.contains(annotation))
							{
								if(annotation.source == "sirius.node" || annotation.source == "sirius.borderednode")
								{
									containerContents.add(annotation)
								}
								else if(a === name)
								{
									containerContents.add(annotation)
								}
							}						
						}
					}
				}
			}
		}
		return containerContents
	}
	
	//Goes through the different objects an container can have and adds it
	private def getContentsString(EAnnotationImpl annotation, NoSQL_SchemaPackage mmPackage)
	{
		//If it finds an element that has the node annotation add it to the list
		if(annotation.source == "sirius.borderednode")
		{
			return getBorderedNodeString(annotation, mmPackage);
		}
		else if(annotation.source == "sirius.node")
		{
			return getSubNodeString(annotation, mmPackage);
		}
		else if(annotation.source == "sirius.container")
		{
			return getSubContainerString(annotation, mmPackage);
		}
	}
	
	//Same as the above but without recursion
	private def getContainedContentsString(EAnnotationImpl annotation, NoSQL_SchemaPackage mmPackage)
	{
		//If it finds an element that has the node annotation add it to the list
		if(annotation.source == "sirius.borderednode")
		{
			return getBorderedNodeString(annotation, mmPackage);
		}
		else if(annotation.source == "sirius.node")
		{
			return getSubNodeString(annotation, mmPackage);
		}
	}
	
	private def getBorderedNodeString(EAnnotationImpl objectAnnotation, NoSQL_SchemaPackage mmPackage)'''
	«val editNameAnnotations = getToolsAnnotation(mmPackage, "DirectEditLabel", objectAnnotation.details.get("name"), objectAnnotation)»
	«val color = objectAnnotation.details.get("color")»
	<borderedNodeMappings name="«objectAnnotation.details.get("name")»"«IF editNameAnnotations !== null» labelDirectEdit="«getToolString(editNameAnnotations, getViewpoint(mmPackage), getDiagram(mmPackage))»"«ENDIF» semanticCandidatesExpression="«objectAnnotation.details.get("expression")»" domainClass="«mmPackage.name»::«objectAnnotation.details.get("domain")»">
	    <style xsi:type="style:«objectAnnotation.details.get("style")»" labelSize="12" showIcon="«objectAnnotation.details.get("icon")»" labelExpression="«objectAnnotation.details.get("label")»" labelPosition="node" resizeKind="NSEW" «getNodeWidth(objectAnnotation)» «getNodeHeight(objectAnnotation)»>
	        <borderColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
	        	<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
	    		«getNodeColorString(objectAnnotation)»
		</style>
	</borderedNodeMappings>
	'''
	private def getNodeColorString(EAnnotationImpl NodeAnnotation)
	{
		var backgroundColor = NodeAnnotation.details.get("color")
		val style = NodeAnnotation.details.get("style")
		if(backgroundColor === null)
		{
			backgroundColor = "black"
		}
		if(style == "DotDescription")
		{
			return '''<backgroundColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«backgroundColor»']"/>'''
		}
		else
		{
			return '''<color xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«backgroundColor»']"/>'''
		}
	}
	
	private def getSubNodeString(EAnnotationImpl objectAnnotation, NoSQL_SchemaPackage mmPackage)'''
	«var color = objectAnnotation.details.get("color")»
	«var border = objectAnnotation.details.get("bordercolor")»
	«var label = objectAnnotation.details.get("labelcolor")»
	«val editNameAnnotations = getToolsAnnotation(mmPackage, "DirectEditLabel", objectAnnotation.details.get("name"), objectAnnotation)»
	<subNodeMappings name="«objectAnnotation.details.get("name")»"«IF editNameAnnotations !== null» labelDirectEdit="«getToolString(editNameAnnotations, getViewpoint(mmPackage), getDiagram(mmPackage))»"«ENDIF» semanticCandidatesExpression="«objectAnnotation.details.get("expression")»" domainClass="«mmPackage.name»::«objectAnnotation.details.get("domain")»">
	    <style xsi:type="style:«objectAnnotation.details.get("style")»" labelSize="12" showIcon="«objectAnnotation.details.get("icon")»" labelExpression="«objectAnnotation.details.get("label")»" sizeComputationExpression="2" labelPosition="node" resizeKind="NSEW" «getNodeWidth(objectAnnotation)» «getNodeHeight(objectAnnotation)»>
		«IF border.isNullOrEmpty»
		<borderColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
		«ELSE»
		<borderColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«border»']"/>
		«ENDIF»
		«IF label.isNullOrEmpty»
		<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
		«ELSE»
		<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«label»']"/>
		«ENDIF»
		«getNodeColorString(objectAnnotation)»
		</style>
		«getAlternateNode(mmPackage, objectAnnotation)»
	</subNodeMappings>
	'''
	private def getSubContainerString(EAnnotationImpl objectAnnotation, NoSQL_SchemaPackage mmPackage)'''
	«val mapping = objectAnnotation.details.get("mapping")»
	«val containerContents = getContainerContents(mmPackage, objectAnnotation.details.get("name"))»
	«val reuseMappings = getContainerContents(mmPackage, mapping)»
	«val editNameAnnotations = getToolsAnnotation(mmPackage, "DirectEditLabel", objectAnnotation.details.get("name"), objectAnnotation)»
	«val presentation = objectAnnotation.details.get("presentation")»
	«val label = objectAnnotation.details.get("label")»
	<subContainerMappings name="«objectAnnotation.details.get("name")»"«IF editNameAnnotations !== null» labelDirectEdit="«getToolString(editNameAnnotations, getViewpoint(mmPackage), getDiagram(mmPackage))»"«ENDIF» semanticCandidatesExpression="«objectAnnotation.details.get("expression")»" domainClass="«mmPackage.name»::«objectAnnotation.details.get("domain")»" «IF mapping !== null»reusedContainerMappings="//@ownedViewpoints[name='«getViewpoint(mmPackage)»']/@ownedRepresentations[name='«getDiagram(mmPackage)»']/@defaultLayer/@containerMappings[name='«mapping»']"«ENDIF»«IF presentation !== null» childrenPresentation="«presentation»"«ENDIF»>
		<style xsi:type="style:FlatContainerStyleDescription" borderSizeComputationExpression="1" «IF label !== null»labelExpression="«label»" «ENDIF» labelSize="12" showIcon="false" roundedCorner="true">
			<borderColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
			<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
		  	<backgroundColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«objectAnnotation.details.get("foreground")»']"/>
		  	<foregroundColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«objectAnnotation.details.get("background")»']"/>
		</style>
		«/*For the a contained containers own contents */»
		«FOR c : containerContents»
			«getContentsString(c, mmPackage)»
		«ENDFOR»
		«/*If it reuses a previous containers mappings it will still need the elements*/»
		«IF mapping !== null»
		«FOR c : reuseMappings»
			«getContainedContentsString(c, mmPackage)»
		«ENDFOR»
		«ENDIF»
	</subContainerMappings>
	'''
	
	private def getNodeAnnotation(EObject o)
	{
		val annotations = o.eContents.filter(EAnnotationImpl).toList()
		for(k : 0 ..< annotations.size())
		{
			val annotation = annotations.get(k)
			if(annotation.source == "sirius.node")
			{
				return annotation
			}
		}
	}
	
	private def getBorderedNodeAnnotation(EObject o)
	{
		val annotations = o.eContents.filter(EAnnotationImpl).toList()
		for(k : 0 ..< annotations.size())
		{
			val annotation = annotations.get(k)
			if(annotation.source == "sirius.borderednode")
			{
				return annotation
			}
		}
	}
	
		private def getContainerAnnotation(EObject o)
	{
		val annotations = o.eContents.filter(EAnnotationImpl).toList()
		for(k : 0 ..< annotations.size())
		{
			val annotation = annotations.get(k)
			if(annotation.source == "sirius.container")
			{
				return annotation
			}
		}
	}
	
	
	private def getEdgeAnnotation(EObject o)
	{
		val annotations = o.eContents.filter(EAnnotationImpl).toList()
		for(k : 0 ..< annotations.size())
		{
			val annotation = annotations.get(k)
			if(annotation.source == "sirius.edge")
			{
				return annotation
			}
		}
	}
	
	private def getToolsAnnotation(NoSQL_SchemaPackage mmPackage, String tool, String name, EAnnotation objectAnnotation)
	{
		val contents = mmPackage.eAllContents.toList
		for(i : 0 ..< contents.size())
		{
			val element = contents.get(i)
			val elementContents = element.eContents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				if(annotation.source == "sirius.tool" && annotation.details.get("type") == tool && annotation.details.get("belongsto") !== null && annotation.details.get("belongsto") == name)
				{
					return annotation
				}
				else if(annotation.source == "sirius.tool" && annotation.details.get("type") == tool)
				{
					val mappings = annotation.details.get("mappings")
					if(mappings !== null)
					{
						val strArr = mappings.split(", ")
						for(m : 0 ..< strArr.size())
						{

							val pair = strArr.get(m).split(":")
							if(strArr.get(m) == name)
							{
								return annotation
							}
							else if(pair.size() >= 2)
							{
								if(pair.get(0) == name)
								{
									val containerArr = objectAnnotation.details.get("container").split(", ")
									if(containerArr.contains(pair.get(1)))
									{
										return annotation
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private def getDoubleClickToolString(NoSQL_SchemaPackage mmPackage, EAnnotationImpl objectAnnotation)'''
    <ownedTools xsi:type="tool:DoubleClickDescription" name="«objectAnnotation.details.get("name")»" mappings="«getMappingString(mmPackage, objectAnnotation, "mappings")»">
    	<element name="element"/>
        <elementView name="elementView"/>
        <initialOperation>
        	«val title = objectAnnotation.details.get("title")»
        	<firstModelOperations xsi:type="properties:DialogModelOperation" «IF title !== null»titleExpression="«objectAnnotation.details.get("title")»"«ELSE»titleExpression="Default"«ENDIF»>
            	<buttons labelExpression="Cancel" closeDialogOnClick="true" rollbackChangesOnClose="true">
        			<initialOperation/>
                </buttons>
                <buttons labelExpression="OK" default="true" closeDialogOnClick="true">
                  <initialOperation>
                    <firstModelOperations xsi:type="tool_1:CreateInstance" typeName="«mmPackage.name»::«objectAnnotation.details.get("targetType")»" referenceName="«objectAnnotation.details.get("reference")»">
                      <subModelOperations xsi:type="tool_1:ChangeContext" browseExpression="«objectAnnotation.details.get("browse")»">
                        <subModelOperations xsi:type="tool_1:SetValue" featureName="«objectAnnotation.details.get("feature")»" valueExpression="var:text"/>
                      </subModelOperations>
                    </firstModelOperations>
                  </initialOperation>
                </buttons>
                <page name="Default Page" labelExpression="Page" domainClass="«mmPackage.name»::«objectAnnotation.details.get("sourceType")»" semanticCandidateExpression="var:self" groups="//@ownedViewpoints[name='«getViewpoint(mmPackage)»']/@ownedRepresentations[name='«getDiagram(mmPackage)»']/@defaultLayer/@toolSections.0/@ownedTools[name='«objectAnnotation.details.get("name")»']/@initialOperation/@firstModelOperations/@groups.0"/>
                <groups name="Default Group" labelExpression="Group" domainClass="«mmPackage.name»::«objectAnnotation.details.get("sourceType")»" semanticCandidateExpression="var:self">
                  	<controls xsi:type="properties:TextDescription" name="TextBox" labelExpression="«objectAnnotation.details.get("label")»">
                    	<initialOperation>
                      		<firstModelOperations xsi:type="tool_1:Let" variableName="text" valueExpression="var:newValue"/>
                    	</initialOperation>
                	</controls>
            	</groups>
        	</firstModelOperations>
    	</initialOperation>
    </ownedTools>
	'''
	
	private def getReconnectionTools(NoSQL_SchemaPackage mmPackage, String tool, String name)
	{
		val contents = mmPackage.eAllContents.toList
		var annotationArr = newArrayList
		for(i : 0 ..< contents.size())
		{
			val element = contents.get(i)
			val elementContents = element.eContents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				if(annotation.source == "sirius.tool" && annotation.details.get("type") == tool && annotation.details.get("belongsto") !== null && annotation.details.get("belongsto") == name)
				{
					annotationArr.add(annotation)
				}
			}
		}
		return annotationArr
	}
	
	private def getUniversalTool(NoSQL_SchemaPackage mmPackage, String tool)
	{
		val contents = mmPackage.eAllContents.toList
		for(i : 0 ..< contents.size())
		{
			val element = contents.get(i)
			val elementContents = element.eContents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				if(annotation.source == "sirius.tool" && annotation.details.get("type") == tool && annotation.details.get("mappings") !== null)
				{
					return annotation
				}
			}
		}
	}
	
	private def getUniversalToolGroup(NoSQL_SchemaPackage mmPackage, String tool)
	{
		val contents = mmPackage.eAllContents.toList
		var arr = newArrayList
		for(i : 0 ..< contents.size())
		{
			val element = contents.get(i)
			val elementContents = element.eContents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				if(annotation.source == "sirius.tool" && annotation.details.get("type") == tool && annotation.details.get("mappings") !== null)
				{
					arr.add(annotation)
				}
			}
		}
		return arr
	}
	
	private def getEdges(NoSQL_SchemaPackage mmPackage)
	{
		val contents = mmPackage.eAllContents.toList
		val edges = newArrayList
		for(i : 0 ..< contents.size())
		{
			val element = contents.get(i)
			val elementContents = element.eContents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				if(annotation.source == "sirius.edge")
				{
					edges.add(element)
				}
			}
		}
		return edges
	}
	
	private def getMappingString(NoSQL_SchemaPackage mmPackage, EAnnotationImpl objectAnnotation, String search)
	{
		var str = ""
		var sourceString = objectAnnotation.details.get(search)
		if(sourceString === null)
		{
			if(search == "mappings")
			{
				sourceString = objectAnnotation.details.get("belongsto")
			}
			else
			{
				sourceString = objectAnnotation.details.get("mappings")
			}
			if(sourceString === null)
			{
				println(objectAnnotation.details.get("name") + " ERROR: Missing both belongsto and mappings")
			}
		}
		val strArr = sourceString.split(", ")
		val contents = mmPackage.eAllContents.toList
		val reusedContainers = getReusedContainers(mmPackage)
		for(i : 0 ..< strArr.size())
		{
			//Separate the contents into separate parts, so it will show element:container. If no container it is in default
			val keyValue = strArr.get(i).split(":")
			var containers = newArrayList;
			if(keyValue.size() >= 2)
			{
				for(c : 0 ..< reusedContainers.size())
				{
					val comparison = reusedContainers.get(c).details.get("mapping")
					if(keyValue.get(1) == comparison)
					{
						containers.add(reusedContainers.get(c))
					}
				}
			}
				for(c : 0 ..< contents.size())
				{
					//Iterate over contents, to find annotations that match (1) the name (2) the container
					val element = contents.get(c)
					val elementContents = element.eContents
					val annotations = elementContents.filter(EAnnotationImpl).toList()
					for(k : 0 ..< annotations.size())
					{
						val annotation = annotations.get(k)
						//Condition above

						if(keyValue.size() < 2)
						{
							if(annotation.source == "sirius.node" && keyValue.get(0) == annotation.details.get("name"))
							{
								str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']/@defaultLayer/@nodeMappings[name='" + keyValue.get(0) + "'] " 
							}
							else if(annotation.source == "sirius.container" && keyValue.get(0) == annotation.details.get("name"))
							{
								str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']/@defaultLayer/@containerMappings[name='" + keyValue.get(0) + "'] " 
							}
							else if(annotation.source == "sirius.edge" && keyValue.get(0) == annotation.details.get("name"))
							{
								str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']/@defaultLayer/@edgeMappings[name='" + keyValue.get(0) + "'] " 
							}
						}
						else if(annotation.details.get("container") !== null)
						{
							//TODO see if the if else is necessary
							val annotationContainers = annotation.details.get("container").split(", ")
							if(annotationContainers.size() > 2)
							{
								if(keyValue.get(0) == annotation.details.get("name") && annotationContainers.contains(keyValue.get(1)))
								{
									//If node assign it as a sub node
									if(annotation.source == "sirius.node")
									{
										str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerStringSearch(mmPackage, annotation, keyValue.get(1)) + "/@subNodeMappings[name='" + keyValue.get(0) + "'] "
										for(r : containers)
										{
											str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerStringSearch(mmPackage, annotation, keyValue.get(1)) + "/@subContainerMappings[name='" + r.details.get("name") + "']" + "/@subNodeMappings[name='" + keyValue.get(0) + "'] "
										} 
									}
									//If border node assign as bordered node
									else if(annotation.source == "sirius.borderednode")
									{
										str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerStringSearch(mmPackage, annotation, keyValue.get(1)) + "/@borderedNodeMappings[name='" + keyValue.get(0) + "'] " 
										for(r : containers)
										{
											str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerStringSearch(mmPackage, annotation, keyValue.get(1)) + "/@subContainerMappings[name='" + r.details.get("name") + "']" + "/@borderedNodeMappings[name='" + keyValue.get(0) + "'] "
										} 
									}
									//If container assign as container
									else if(annotation.source == "sirius.container")
									{
										if(annotation.details.get("mapping") !== null)
										{
											str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerStringSearch(mmPackage, annotation, keyValue.get(1)) + " "
											//str = str + getReuseString(mmPackage, annotation.details.get("mapping"), annotation, a, search)
										}
										else
										{
											str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerStringSearch(mmPackage, annotation, keyValue.get(1)) + " "
										}
									}
								}
							}
							else 
							{
								if(keyValue.get(0) == annotation.details.get("name") && annotationContainers.contains(keyValue.get(1)))
								{
									//If node assign it as a sub node
									if(annotation.source == "sirius.node")
									{
										str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerString(mmPackage, element, annotation) + "/@subNodeMappings[name='" + keyValue.get(0) + "'] "
										for(r : containers)
										{
											str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerString(mmPackage, element, annotation) + "/@subContainerMappings[name='" + r.details.get("name") + "']" + "/@subNodeMappings[name='" + keyValue.get(0) + "'] "
										} 
									}
									//If border node assign as bordered node
									else if(annotation.source == "sirius.borderednode")
									{
										str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerString(mmPackage, element, annotation) + "/@borderedNodeMappings[name='" + keyValue.get(0) + "'] " 
										for(r : containers)
										{
											str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerString(mmPackage, element, annotation) + "/@subContainerMappings[name='" + r.details.get("name") + "']" + "/@borderedNodeMappings[name='" + keyValue.get(0) + "'] "
										} 
									}
									//If container assign as container
									else if(annotation.source == "sirius.container")
									{
										if(annotation.details.get("mapping") !== null)
										{
											str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerString(mmPackage, element, annotation) + " "
											//str = str + getReuseString(mmPackage, annotation.details.get("mapping"), annotation, a, search)
										}
										else
										{
											str = str + "//@ownedViewpoints[name='"+ getViewpoint(mmPackage) + "']/@ownedRepresentations[name='"+ getDiagram(mmPackage) +"']" + getContainerString(mmPackage, element, annotation) + " "
										}
									}
								} 
							}
						}					
				}
			}
		}
		return str
	}

	private def getReusedContainers(NoSQL_SchemaPackage mmPackage)
	{
		val contents = mmPackage.eAllContents.toList
		var containerArr = newArrayList
			for(c : 0 ..< contents.size())
			{
				val element = contents.get(c)
					val elementContents = element.eContents
					val annotations = elementContents.filter(EAnnotationImpl).toList()
					for(k : 0 ..< annotations.size())
					{
						val annotation = annotations.get(k)
						if(annotation.source == "sirius.container" && annotation.details.get("mapping") !== null)
						{
							containerArr.add(annotation)
						}
					}					
			}
			return containerArr
	}
	
	//Could probably be more effective with a find function or something
	//Function searches through whole list to find container in a, if match gets 
	private def getContainerString(NoSQL_SchemaPackage mmPackage, EObject o, EAnnotationImpl objectAnnotation)
	{
			val contents = mmPackage.eAllContents.toList
			for(c : 0 ..< contents.size())
			{
				val element = contents.get(c)
					val elementContents = element.eContents
					val annotations = elementContents.filter(EAnnotationImpl).toList()
					for(k : 0 ..< annotations.size())
					{
						val annotation = annotations.get(k)
						val container = annotation.details.get("name")
						val objectContainers = objectAnnotation.details.get("container").split(", ")
						if(objectAnnotation.details.get("container") == "default" && annotation.source == "sirius.container")
						{
							return "/@defaultLayer/@containerMappings[name='" + container + "']"
						}
						else if(objectContainers.contains(container) && objectAnnotation.source == "sirius.container")
						{
							return getContainerString(mmPackage, element, annotation) + "/@subContainerMappings[name='" + objectAnnotation.details.get("name") + "']"
						}
						else if(objectContainers.contains(container))
						{
							return getContainerString(mmPackage, element, annotation)
						}
					}					
			}
	}
	
		private def getContainerStringSearch(NoSQL_SchemaPackage mmPackage, EAnnotationImpl objectAnnotation, String search)
	{
			val contents = mmPackage.eAllContents.toList
			for(c : 0 ..< contents.size())
			{
				val element = contents.get(c)
					val elementContents = element.eContents
					val annotations = elementContents.filter(EAnnotationImpl).toList()
					for(k : 0 ..< annotations.size())
					{
						val annotation = annotations.get(k)
						val container = annotation.details.get("name")
						val objectContainers = objectAnnotation.details.get("container").split(", ")
						if(objectAnnotation.details.get("container") == "default" && annotation.source == "sirius.container")
						{
							return "/@defaultLayer/@containerMappings[name='" + container + "']"
						}
						else if(objectContainers.contains(container) && objectAnnotation.source == "sirius.container" && container == search)
						{
							return getContainerString(mmPackage, element, annotation) + "/@subContainerMappings[name='" + objectAnnotation.details.get("name") + "']"
						}
						else if(objectContainers.contains(container) && container == search)
						{
							return getContainerString(mmPackage, element, annotation)
						}
					}					
			}
	}
	
	private def getAlternateEdge(NoSQL_SchemaPackage mmPackage, EAnnotationImpl objectAnnotation)
	{
		val contents = mmPackage.eAllContents.toList
		var str = ""
		for(c : 0 ..< contents.size())
		{
			val element = contents.get(c)
			val elementContents = element.eContents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				if(annotation.details.get("belongsto") !== null && annotation.details.get("belongsto") == objectAnnotation.details.get("name") && annotation.source == "sirius.altedge")
				{
					str += getAlternateEdgeString(annotation, objectAnnotation)
				}
			}
		}
		return str
	}
	
	private def getAlternateNode(NoSQL_SchemaPackage mmPackage, EAnnotationImpl objectAnnotation)
	{
		val contents = mmPackage.eAllContents.toList
		var str = ""
		for(c : 0 ..< contents.size())
		{
			val element = contents.get(c)
			val elementContents = element.eContents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				if(annotation.details.get("belongsto") !== null && annotation.details.get("belongsto") == objectAnnotation.details.get("name") && annotation.source == "sirius.altnode")
				{
					str += getAlternateNodeString(annotation, objectAnnotation)
				}
			}
		}
		return str
	}
	
	private def getAlternateEdgeString(EAnnotationImpl AlternateEdge, EAnnotationImpl SourceEdge) '''
	«val alternateColor = AlternateEdge.details.get("color")»
	<conditionnalStyles predicateExpression="«AlternateEdge.details.get("condition")»">
		<style sizeComputationExpression="2">
		    «IF alternateColor !== null»
		        	<strokeColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«alternateColor»']"/>
		        	«ELSE»
		        		«IF SourceEdge.details.get("color") !== null»
		        			<strokeColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«SourceEdge.details.get("color")»']"/>
		        		«ELSE»
		        			<strokeColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='grey']"/>
		        	«ENDIF»
		        	«ENDIF»
    «IF AlternateEdge.details.get("label") !== null»
    	<centerLabelStyleDescription labelSize="12" showIcon="false" labelExpression="«AlternateEdge.details.get("label")»">
        	«ELSE»
        	<centerLabelStyleDescription labelSize="12" showIcon="false" labelExpression="«SourceEdge.details.get("label")»">
        	«ENDIF»
			<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>	
		</centerLabelStyleDescription>
		</style>
	</conditionnalStyles>
	'''	
	private def getAlternateNodeString(EAnnotationImpl AlternateNode, EAnnotationImpl SourceNode) '''
	«val alternateColor = AlternateNode.details.get("color")»
	«val label = AlternateNode.details.get("label")»
	<conditionnalStyles predicateExpression="«AlternateNode.details.get("condition")»">
		<style xsi:type="style:«AlternateNode.details.get("style")»" labelSize="12" «IF label !== null»labelExpression="«AlternateNode.details.get("label")»" «ELSE»labelExpression="«SourceNode.details.get("label")»" «ENDIF»labelPosition="node" resizeKind="NSEW">
			<borderColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
        	«IF alternateColor !== null»
        		<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«alternateColor»']"/>
        	«ELSE»
        		«IF SourceNode.details.get("color") !== null»
        			<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='«SourceNode.details.get("color")»']"/>
        		«ELSE»
        			<labelColor xsi:type="description:SystemColor" href="environment:/viewpoint#//@systemColors/@entries[name='black']"/>
        	«ENDIF»
        	«ENDIF»	
		</style>
	</conditionnalStyles>
	'''		

	private def getDecorations(NoSQL_SchemaPackage mmPackage)
	{
		val contents = mmPackage.eAllContents.toList
		var arr = newArrayList
		for(c : 0 ..< contents.size())
		{
			val element = contents.get(c)
			val elementContents = element.eContents
			val annotations = elementContents.filter(EAnnotationImpl).toList()
			for(k : 0 ..< annotations.size())
			{
				val annotation = annotations.get(k)
				if(annotation.source == "sirius.decoration")
				{
					
					arr.add(annotation)
				}
			}

		}
		if(arr.size > 0)
		{
			return getDecorationString(arr, mmPackage)
		}
		return "";
	}
	
	private def getDecorationString(ArrayList<EAnnotationImpl> arr, NoSQL_SchemaPackage mmPackage) '''
	<decorationDescriptionsSet>
	«FOR objectAnnotation : arr»
	<decorationDescriptions xsi:type="description_1:MappingBasedDecoration" name="«objectAnnotation.details.get("name")»" position="«objectAnnotation.details.get("position")»" preconditionExpression="«objectAnnotation.details.get("expression")»" imageExpression="/«getPath(mmPackage)»/«objectAnnotation.details.get("image")»" mappings="«getMappingString(mmPackage, objectAnnotation, "mappings")»"/>
	«ENDFOR»
	</decorationDescriptionsSet>
	'''	
	
	private def getToolString(EAnnotationImpl objectAnnotation, String viewpoint, String diagram)
	{
		var str = ""
		val value = objectAnnotation.details.get("name")
		str = "//@ownedViewpoints[name='"+ viewpoint + "']/@ownedRepresentations[name='"+ diagram +"']/@defaultLayer/@toolSections.0/@ownedTools[name='"+ value +"'] " 
		return str
	}
}