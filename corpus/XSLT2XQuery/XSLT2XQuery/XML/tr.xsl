<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
	<xsl:template match="/">
		<emps>
		  <xsl:apply-templates select="employee"/>
		</emps>
	</xsl:template>
	<xsl:template match="employee">
	  <xsl:if test="salary&gt;2000">
	    <emp>
	      <xsl:value-of select="name"/>
	      <xsl:value-of select="firstname"/>
	    </emp>
	  </xsl:if>
	</xsl:template>
</xsl:stylesheet>
