# memoryanalyzersamples

[Eclipse Memory Analyzer Tool](https://eclipse.dev/mat/) (MAT) sample plugin and feature implementing MAT extensions:

* [Query](https://help.eclipse.org/latest/index.jsp?topic=/org.eclipse.mat.ui.help/doc/org_eclipse_mat_report_query.html)
* [Name Resolver](https://help.eclipse.org/latest/index.jsp?topic=/org.eclipse.mat.ui.help/doc/org_eclipse_mat_api_nameResolver.html)

## Development

1. Download:
   ```
   git clone https://github.com/IBM/memoryanalyzersamples
   ```
2. Enter the directory:
   ```
   cd memoryanalyzersamples
   ```
3. Build (assuming Apache Maven and Java installed and on `PATH`):
   ```
   mvn clean install
   ```
4. Launch MAT
5. Help } Install New Software...
6. Work with: } Add... } Local...
7. Select `memoryanalyzersamples/com.example.matsample.updatesite/target/repository/`
8. Select the new update site in the "Work with:" dropdown
9. Check "MAT Samples" and finish the dialog
