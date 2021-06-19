  <aside class="main-sidebar elevation-4 sidebar-light-warning">
                <!-- Brand Logo -->
                <a href="#" class="brand-link">
                    <img src="./mira_assets/img/miraLogo.png" alt="mira Logo" class="brand-image"
                         style="opacity: .8">
                    <span class="brand-text font-weight-light">SORMAS HL7/FHIR</span>
                </a>

                <!-- Sidebar -->
                <div class="sidebar os-host os-theme-light os-host-resize-disabled os-host-scrollbar-horizontal-hidden os-host-transition os-host-overflow os-host-overflow-y">
                    <!-- Sidebar user panel (optional) -->
                    <!-- Sidebar Menu -->
                    <nav class="mt-2">
                        <ul class="nav nav-pills nav-sidebar flex-column  nav-compact" data-widget="treeview" role="menu" data-accordion="false">
                            <!-- Add icons to the links using the .nav-icon class
                                 with font-awesome or any other icon font library -->
                            <li class="nav-item has-treeview menu-close" id="facl">
                                <a href="#" class="nav-link" onclick="cases_()">
                                    <p style="font-size:14px">
                                        Organization Tool Module
                                        <i class="right fas fa-angle-left"></i>
                                    </p>
                                </a>
                                <ul class="nav nav-treeview">
                                    <li class="nav-item">
                                        <a href="../" class="nav-link">
                                            <i class="fas fa-chart-bar nav-icon"></i>
                                            <p style="font-size:12px">Dashboard</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="source_controller.jsp" class="nav-link">
                                            <i class="fas fa-cogs nav-icon"></i>
                                            <p style="font-size:12px">Configuration</p>
                                        </a>
                                    </li>

                                    <li class="nav-item">
                                        <a href="OrgToolOperation.jsp" class="nav-link">
                                            <i class="fas fa-exchange-alt nav-icon"></i>
                                            <p style="font-size:12px">Operations</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>   
                            <li class="nav-item has-treeview menu-close" id="caxl">
                                <a href="#" class="nav-link" onclick="cases()">
                                    <p style="font-size:14px">
                                        Aggregate Module
                                        <i class="right fas fa-angle-left"></i>
                                    </p>
                                </a>
                                
                                <ul class="nav nav-treeview">
                                    <!--li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="fas fa-chart-bar nav-icon"></i>
                                            <p style="font-size:12px">Dashboard</p>
                                        </a>
                                    </li-->
                                    <li class="nav-item">
                                        <a href="controller.jsp" class="nav-link">
                                            <i class="fas fa-cogs nav-icon"></i>
                                            <p style="font-size:12px">Maintenance</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="datalog.jsp" class="nav-link">
                                            <i class="fas fa-exchange-alt nav-icon"></i>
                                            <p style="font-size:12px">Operation Logs</p>
                                        </a>
                                </li>
                                </ul>
                            </li>
                            
                             <li class="nav-item has-treeview menu-close" id="caxl">
                                <a href="#" class="nav-link" onclick="cases()">
                                    <p style="font-size:14px">
                                        Case Based Module
                                        <i class="right fas fa-angle-left"></i>
                                    </p>
                                </a>
                                
                                <ul class="nav nav-treeview">
                                    <!--li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="fas fa-chart-bar nav-icon"></i>
                                            <p style="font-size:12px">Dashboard</p>
                                        </a>
                                    </li-->
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="fas fa-cogs nav-icon"></i>
                                            <p style="font-size:12px">Maintenance</p>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="#" class="nav-link">
                                            <i class="fas fa-exchange-alt nav-icon"></i>
                                            <p style="font-size:12px">Operation Logs</p>
                                        </a>
                                </li>
                                </ul>
                            </li>

                            <li class="nav-header">Settings</li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="fas fa-user"></i>
                                    <p>
                                        User Management
                                    </p>
                                </a>
                            </li>
                            <!--li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="fas fa-sign-in-alt"></i>
                                    <p>
                                        Source Setting
                                    </p>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="fas fa-sync-alt"></i>
                                    <p>
                                        Sync Setting
                                    </p>
                                </a>
                            </li-->
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="fas fa-chart-line"></i>
                                    <p>
                                        Analytics
                                    </p>
                                </a>
                            </li>
                    </nav>
                    <!-- /.sidebar-menu -->
                </div>
                <!-- /.sidebar -->
                
            </aside>