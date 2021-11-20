import xlrd

workbook = xlrd.open_workbook('C:/thivirepository/PythonLearnings/TestData/Automation Test Sheet.xls')
sheet = workbook.sheet_by_name('Sheet1')

print(sheet.nrows)

print(sheet.cell_value(1,1))