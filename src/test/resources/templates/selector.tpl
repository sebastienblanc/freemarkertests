<#macro selectWidget widgetType>
<#if widgetType == "String">
<@renderer.stringRenderer/>
</#if>
<#if widgetType == "Date">
<@renderer.dateRenderer/>
</#if>
</#macro>

