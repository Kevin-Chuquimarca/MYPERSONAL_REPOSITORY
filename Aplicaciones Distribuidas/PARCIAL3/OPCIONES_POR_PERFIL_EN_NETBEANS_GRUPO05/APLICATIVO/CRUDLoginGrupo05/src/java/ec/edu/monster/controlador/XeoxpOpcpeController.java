package ec.edu.monster.controlador;

import ec.edu.monster.modelo.entidades.XeoxpOpcpe;
import ec.edu.monster.controlador.util.JsfUtil;
import ec.edu.monster.controlador.util.PaginationHelper;
import ec.edu.monster.modelo.jpa.XeoxpOpcpeFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("xeoxpOpcpeController")
@SessionScoped
public class XeoxpOpcpeController implements Serializable {

    private XeoxpOpcpe current;
    private DataModel items = null;
    @EJB
    private ec.edu.monster.modelo.jpa.XeoxpOpcpeFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public XeoxpOpcpeController() {
    }

    public XeoxpOpcpe getSelected() {
        if (current == null) {
            current = new XeoxpOpcpe();
            current.setXeoxpOpcpePK(new ec.edu.monster.modelo.entidades.XeoxpOpcpePK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private XeoxpOpcpeFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (XeoxpOpcpe) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new XeoxpOpcpe();
        current.setXeoxpOpcpePK(new ec.edu.monster.modelo.entidades.XeoxpOpcpePK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getXeoxpOpcpePK().setXeopcCodigo(current.getXeopcOpcio().getXeopcCodigo());
            current.getXeoxpOpcpePK().setXeperCodigo(current.getXeperPerfi().getXeperCodigo());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("XeoxpOpcpeCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (XeoxpOpcpe) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getXeoxpOpcpePK().setXeopcCodigo(current.getXeopcOpcio().getXeopcCodigo());
            current.getXeoxpOpcpePK().setXeperCodigo(current.getXeperPerfi().getXeperCodigo());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("XeoxpOpcpeUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (XeoxpOpcpe) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("XeoxpOpcpeDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public XeoxpOpcpe getXeoxpOpcpe(ec.edu.monster.modelo.entidades.XeoxpOpcpePK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = XeoxpOpcpe.class)
    public static class XeoxpOpcpeControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            XeoxpOpcpeController controller = (XeoxpOpcpeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "xeoxpOpcpeController");
            return controller.getXeoxpOpcpe(getKey(value));
        }

        ec.edu.monster.modelo.entidades.XeoxpOpcpePK getKey(String value) {
            ec.edu.monster.modelo.entidades.XeoxpOpcpePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new ec.edu.monster.modelo.entidades.XeoxpOpcpePK();
            key.setXeopcCodigo(values[0]);
            key.setXeperCodigo(values[1]);
            key.setXeoxpFecasi(java.sql.Date.valueOf(values[2]));
            return key;
        }

        String getStringKey(ec.edu.monster.modelo.entidades.XeoxpOpcpePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getXeopcCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getXeperCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getXeoxpFecasi());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof XeoxpOpcpe) {
                XeoxpOpcpe o = (XeoxpOpcpe) object;
                return getStringKey(o.getXeoxpOpcpePK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + XeoxpOpcpe.class.getName());
            }
        }

    }

}
