import timeusage.TimeUsage._


val (columns, initDf) = read("/timeusage/atussum.csv")


val (primaryNeedsColumns, workColumns, otherColumns) = classifiedColumns(columns)


val summaryDf = timeUsageSummary(primaryNeedsColumns, workColumns, otherColumns, initDf)


timeUsageGrouped(summaryDf).show()

timeUsageGroupedSql(summaryDf).show()

timeUsageGroupedTyped(timeUsageSummaryTyped(summaryDf)).show()
